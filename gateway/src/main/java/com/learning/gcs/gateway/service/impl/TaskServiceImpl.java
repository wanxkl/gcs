package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.gateway.bean.Task;
import com.learning.gcs.gateway.service.DeviceService;
import com.learning.gcs.gateway.service.GcsTaskService;
import com.learning.gcs.gateway.service.TaskService;
import com.learning.gcs.gateway.service.VpnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private DeviceService   deviceService;
    @Autowired
    private GcsTaskService gcsTaskService;
    @Autowired
    private VpnService vpnService;

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
                task.getTaskList().add(gcsTask);
                task.getBlackList().add(gcsTask.getPackageName());
                if(gcsTask.getTaskModeCode() == 2 ) {
                    task.getBlackList().add(gcsTask.getMarketPackName());
                }
            }


            task.setVpn(vpnService.getVpnByDeviceId(deviceId));

            task.setConfig(null);
            task.setInfo(null);
        }


        return task;
    }

    @Override
    public List<GcsTask> getCurrentTaskList() {
        return null;
    }
}
