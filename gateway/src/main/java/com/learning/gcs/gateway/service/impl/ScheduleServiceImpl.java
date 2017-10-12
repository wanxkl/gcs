package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.util.TimeUtil;
import com.learning.gcs.gateway.service.*;
import com.learning.gcs.gateway.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    @Value("${com.learning.gcs.gateway.scheduleToggle}")
    private String scheduleToggle;
    @Autowired
    private QueueService queueService;
    @Autowired
    private GcsTaskService gcsTaskService;
    @Autowired
    private CountService countService;
    @Autowired
    private PhoneNumberService phoneNumberService;

    //每天0点执行
    @Scheduled(cron = "0 0 0 * * ?")
//    @Scheduled(cron = "0/5 * * * * ?")
    @Override
    public void clearTaskHourCount() {
        logger.info("检查开关状态:{}", scheduleToggle);
        if (Constant.SCHEDULE_TOGGLE_ENABLE.equals(scheduleToggle)) {
            logger.info("开始清空TaskHourCount:{}", TimeUtil.getFormatTime());
            Long beninTime = System.currentTimeMillis();
            Integer deleteCount = countService.deleteTaskCount();
            Long totalTime = System.currentTimeMillis() - beninTime;
            logger.info("清空taskCount完毕，清除key:{}个,耗时:{}毫秒", deleteCount, totalTime);
        }
    }
    //每小时执行
    @Scheduled(cron = "0 0 * * * ?")
    @Override
    public void generateCurrentHourTask() {
        logger.info("检查开关状态:{}", scheduleToggle);
        if (Constant.SCHEDULE_TOGGLE_ENABLE.equals(scheduleToggle)) {
            logger.info("开始生成小时队列:{}", TimeUtil.getFormatTime());
            List<GcsTask> taskList = gcsTaskService.findAll();
            Integer hour = Integer.parseInt(TimeUtil.getCurrentHour());
            for (GcsTask gcsTask : taskList) {
                try {
                    Integer queueCount = queueService.generateQueueByTaskIdAndHour(gcsTask.getId(), hour);
                    logger.info("生成:-{}:{}-任务成功({})", gcsTask.getId(), gcsTask.getAppName(), queueCount);
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("生成:-{}:{}-任务异常({}):{}", gcsTask.getId(), gcsTask.getAppName(), TimeUtil.getFormatTime(), e);
                }
            }
        }
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    @Override
    public void synPhoneNumber() {
        logger.info("检查开关状态:{}", scheduleToggle);
        if (Constant.SCHEDULE_TOGGLE_ENABLE.equals(scheduleToggle)) {
            logger.info("开始执行synPhoneNumber():", TimeUtil.getFormatTime());
            long beginTime = System.currentTimeMillis();
            Integer synCount = phoneNumberService.synPhoneNumber();
            long totalTime = System.currentTimeMillis() - beginTime;
            logger.info("结束执行synPhoneNumber():同步手机号个数：{},耗时:{}",synCount,totalTime);
        }

    }
}
