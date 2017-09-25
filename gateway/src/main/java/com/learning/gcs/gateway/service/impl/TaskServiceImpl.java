package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskRecord;
import com.learning.gcs.common.repository.GcsTaskRecordRepository;
import com.learning.gcs.gateway.adapter.TaskConfigAdapter;
import com.learning.gcs.gateway.adapter.TaskSimpleAdapter;
import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import com.learning.gcs.gateway.service.*;
import com.learning.gcs.gateway.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private MachineService   machineService;
    @Autowired
    private GcsTaskService gcsTaskService;
    @Autowired
    private VpnService vpnService;
    @Autowired
    private GcsTaskConfigService gcsTaskConfigService;
    @Autowired
    private GcsDeviceInfoService gcsDeviceInfoService;
    @Autowired
    private GcsTaskRecordService gcsTaskRecordService;

    @Override
    public Task get(String deviceId) {
        Task task = null;

        //通过deviceId获取可做任务
        //可做任务：deviceId任务列表&当前时间可做任务

        List<Object> validTaskId = gcsTaskService.getValidTaskIds(deviceId);

        if(!ObjectUtils.isEmpty(validTaskId)){

            task = new Task();
            for (Object o : validTaskId) {
                GcsTask gcsTask = gcsTaskService.getByTaskId(Integer.valueOf(o.toString()));
                task.getTaskList().add(new TaskSimpleAdapter(gcsTask).build());
                task.getBlackList().add(gcsTask.getPackageName());
                if(gcsTask.getTaskModeCode() == 2 ) {
                    task.getBlackList().add(gcsTask.getMarketPackName());
                }
            }
            task.setVpn(vpnService.getVpnByDeviceId(deviceId));
            task.setConfig(new TaskConfigAdapter(gcsTaskConfigService.getGcsTaskConfig()).build());
            task.setInfo(gcsDeviceInfoService.getByTaskId(Integer.valueOf(validTaskId.get(0).toString())));

        }

        return task;
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
    public Result saveGcsTaskRecord(String deviceId, String imei, int taskId,int rt) {
        GcsTaskRecord gcsTaskRecord = new GcsTaskRecord(taskId,imei);
        gcsTaskRecord.setDailyActiveTimes(0);
        gcsTaskRecord.setRt(rt);
        gcsTaskRecord.setDailyActiveTimes(0);
        gcsTaskRecord.setLogStatus(0);
        gcsTaskRecordService.save(gcsTaskRecord);
        return Constant.RESULT_SUCCESS;
    }
}
