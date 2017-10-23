package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.*;
import com.learning.gcs.common.util.TimeUtil;
import com.learning.gcs.gateway.adapter.TaskConfigAdapter;
import com.learning.gcs.gateway.adapter.TaskSimpleAdapter;
import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import com.learning.gcs.gateway.bean.TaskConfig;
import com.learning.gcs.gateway.service.*;
import com.learning.gcs.gateway.util.Constant;
import com.learning.gcs.gateway.util.WeightRandom;
import org.apache.commons.math3.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    @Autowired
    private MachineService           machineService;
    @Autowired
    private GcsTaskService           gcsTaskService;
    @Autowired
    private VpnService               vpnService;
    @Autowired
    private GcsTaskConfigService     gcsTaskConfigService;
    @Autowired
    private GcsDeviceInfoService     gcsDeviceInfoService;
    @Autowired
    private GcsTaskRecordService     gcsTaskRecordService;
    @Autowired
    private RemainCurveDetailService remainCurveDetailService;
    @Autowired
    private CountService             countService;
    @Autowired
    private QueueService             queueService;

    @Override
    public Task get(String deviceId) throws IOException {
        Task task = new Task();
        Integer hour = Integer.valueOf(TimeUtil.getCurrentHour());
        //通过deviceId获取可做任务
        //可做任务：deviceId任务列表&当前时间可做任务
        List<Integer> validTaskId = gcsTaskService.getValidTaskIds(deviceId);
        //根据Weight获取任务，目前只支持一个
        List<Pair<GcsTask, Integer>> weightList = new ArrayList<>();
        GcsTaskConfig gcsTaskConfig = gcsTaskConfigService.getGcsTaskConfig();
        if (!ObjectUtils.isEmpty(validTaskId)&&gcsTaskConfig.isState()) {
            for (Integer integer : validTaskId) {
                GcsTask gcsTask = gcsTaskService.getByTaskId(integer);
                weightList.add(new Pair<>(gcsTask, gcsTask.getWeight()));
            }
            GcsTask weightGcsTask = (GcsTask) new WeightRandom(weightList).random();
            task.getTaskList().add(new TaskSimpleAdapter(weightGcsTask).build());
            task.getBlackList().add(weightGcsTask.getPackageName());
            if (weightGcsTask.getTaskModeCode() == 2) {
                task.getBlackList().add(weightGcsTask.getMarketPackName());
            }

            //从留存队列中获取任务设备信息
            GcsDeviceInfo gcsDeviceInfo = queueService.getDeviceInfoByTaskId(weightGcsTask.getId(), hour);
            if (!ObjectUtils.isEmpty(gcsDeviceInfo)) {
                //开始做留存任务
                //记录设备已完成当次留存任务
                gcsTaskRecordService.updateRtByTaskIdAndImei(weightGcsTask.getId(), gcsDeviceInfo.getImei());
            } else {
                //当前小时留存已经做完，开始新增任务
                if (!taskIsDone(weightGcsTask)) {
                    gcsDeviceInfo = gcsDeviceInfoService.getByTaskId(Integer.valueOf(validTaskId.get(0).toString()));
                } else {
                    task.setConfig(Constant.TASK_CONFIG_DONE_HOUR);
                }
            }

            if (!ObjectUtils.isEmpty(gcsDeviceInfo)) {
                task.setVpn(vpnService.getVpnByDeviceId(deviceId));
                task.setConfig(new TaskConfigAdapter(gcsTaskConfigService.getGcsTaskConfig()).build());
                task.setInfo(gcsDeviceInfo);
            } else {
                TaskConfig taskConfig = new TaskConfigAdapter(gcsTaskConfig).build();
                taskConfig.setMessage("TaskId没有合适的DeviceInfo");
                taskConfig.setState(false);
                task.setConfig(taskConfig);
            }

        } else {
            TaskConfig taskConfig = new TaskConfigAdapter(gcsTaskConfig).build();
            taskConfig.setMessage("AsoId没有合适的Task");
            taskConfig.setState(false);
            task.setConfig(taskConfig);
        }
        return task;
    }


    private boolean taskIsDone(GcsTask gcsTask) throws IOException {
        int taskCount = gcsTask.getTaskCount();
        int hour = Integer.parseInt(TimeUtil.getCurrentHour());
        float percent = getPercent(hour, gcsTask.getNewAddRemainCurveId());
        int hourTaskCount = (int) (taskCount * percent * 0.01f);
        if (countService.getTaskCount(gcsTask.getId(), hour) <= hourTaskCount) {
            int doneCount = countService.getAndSetTaskCount(gcsTask.getId(), hour);
            logger.info("任务进行中：当前ID:{},总任务:{},小时:{},计划数:{},完成数:{}", gcsTask.getId(), taskCount, hour, hourTaskCount, doneCount);
            return false;
        } else {
            logger.info("任务结束：当前ID:{},总任务:{},小时:{},计划数:{},完成数:{}", gcsTask.getId(), taskCount, hour, hourTaskCount, countService.getTaskCount(gcsTask.getId(), hour));
        }
        return true;
    }

    private float getPercent(int hour, Integer remainCurveId) throws IOException {
        List<RemainCurveDetail> details = remainCurveDetailService.getRemainCurveDetailByRemainCurveId(remainCurveId);
        for (RemainCurveDetail detail : details) {
            if (hour == detail.getDistance()) {
                return detail.getPercent();
            }
        }
        return 0;
    }

    @Override
    public List<GcsTask> getCurrentTaskList() {


        return null;
    }

    @Override
    public Result saveGcsTaskRecord(GcsTaskRecord gcsTaskRecord) {
        gcsTaskRecordService.save(gcsTaskRecord);
        return Constant.RESULT_SUCCESS;
    }

    @Override
    public Result saveGcsTaskRecord(String deviceId, String imei, int taskId, int rt) {
        GcsTaskRecord gcsTaskRecord = new GcsTaskRecord(taskId, imei);
        gcsTaskRecord.setDailyActiveTimes(0);
        gcsTaskRecord.setRt(rt);
        gcsTaskRecord.setDailyActiveTimes(0);
        gcsTaskRecord.setLogStatus(0);
        gcsTaskRecordService.save(gcsTaskRecord);

        return Constant.RESULT_SUCCESS;
    }

    @Override
    public Boolean isAddUser(Integer taskId, String addUser) {
        return gcsTaskRecordService.countByTaskIdAndImei(taskId, addUser) == 0 ? true : false;
    }
}
