package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsDeviceInfo;
import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskRecord;
import com.learning.gcs.common.entity.RemainCurveDetail;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.util.TimeUtil;
import com.learning.gcs.gateway.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

    private static final Logger logger = LoggerFactory.getLogger(QueueServiceImpl.class);

    @Autowired
    private RedisWriter redisWriter;

    @Autowired
    private RedisReader redisReader;

    @Autowired
    private GcsDeviceInfoService gcsDeviceInfoService;

    @Autowired
    private GcsTaskService gcsTaskService;

    @Autowired
    private RemainCurveDetailService remainCurveDetailService;

    @Autowired
    private GcsTaskRecordService gcsTaskRecordService;

    @Override
    public GcsDeviceInfo getDeviceInfoByTaskId(Integer taskId,Integer hour) throws IOException {
        //获取队列中下一个imei
        //通过imei获取设备信息
        Object o = redisWriter.rightPop(KeyUtil.generateQueueKey(taskId, hour));

        if (!ObjectUtils.isEmpty(o)) {
            String imei = o.toString();
            return gcsDeviceInfoService.get(imei);
        }
        return null;
    }

    @Override
    public Integer generateQueueByTaskIdAndHour(Integer taskId, Integer hour) throws IOException {
        //TODO 生成下一个小时的队列
        //hour += 1;
        int queueCount = 0;
        //redisWriter.leftPush(KeyUtil.generateQueueKey(1),"1");
        //生成当前任务，下一个小时的任务队列
        GcsTask gcsTask = gcsTaskService.getByTaskId(taskId);
        //留存曲线
        List<RemainCurveDetail> remainCurve = remainCurveDetailService.getRemainCurveDetailByRemainCurveId(gcsTask.getRemainCurveId());
        //留存日曲线
        List<RemainCurveDetail> nichijouRemainCurve = remainCurveDetailService.getRemainCurveDetailByRemainCurveId(gcsTask.getNichijouRemainCurveId());
        float hourPercent = getRemainCurveDetailByHour(nichijouRemainCurve, hour);

        for (RemainCurveDetail remainCurveDetail : remainCurve) {
            int distinct = remainCurveDetail.getDistance();
            float percent = remainCurveDetail.getPercent();
            String remainDate = TimeUtil.getFormatDateDistinceNow(distinct);
            List<GcsTaskRecord> list = gcsTaskRecordService.findByTaskIdAndRtAndCreateDate(taskId, remainDate, distinct);
            if (list.size() > 0) {
                int endIndex = (int) Math.rint(list.size() * percent * 0.01 * hourPercent * 0.01);
                List<GcsTaskRecord> subList =  list.subList(0, endIndex == list.size() ? endIndex - 1 : endIndex);
                for (GcsTaskRecord gcsTaskRecord : subList) {
                    redisWriter.leftPush(KeyUtil.generateQueueKey(taskId,hour), gcsTaskRecord.getImei());
                    queueCount++;
                }

            }

        }
        return queueCount;
    }

    @Override
    public Integer generateQueueByTaskId(Integer taskId) {
        return null;
    }

    private Float getRemainCurveDetailByHour(List<RemainCurveDetail> list, int hour) {
        for (RemainCurveDetail remainCurveDetail : list) {
            if (hour == remainCurveDetail.getDistance()) {
                return remainCurveDetail.getPercent();
            }
        }

        return 0f;
    }
}
