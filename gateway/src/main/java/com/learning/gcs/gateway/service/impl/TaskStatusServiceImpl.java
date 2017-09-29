package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.gateway.bean.TaskStatus;
import com.learning.gcs.gateway.service.GcsTaskService;
import com.learning.gcs.gateway.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskStatusServiceImpl implements TaskStatusService{

    @Autowired
    private GcsTaskService gcsTaskService;

    @Override
    public TaskStatus getByTaskIdAndHour(Integer taskId,String currentDate, Integer currentHour) {
        TaskStatus taskStatus = new TaskStatus();
        GcsTask gcsTask = gcsTaskService.getByTaskId(taskId);
        taskStatus.setTaskId(gcsTask.getId());
        taskStatus.setTaskName(gcsTask.getAppName());
        taskStatus.setCurrentDate(currentDate);
        taskStatus.setCurrentHour(currentHour);

        //当前小时计划数
        taskStatus.setPlanTaskCount(gcsTask.getTaskCount());
        taskStatus.setCurrentHourPlanTaskCount(0);
        taskStatus.setCurrentHourPlanDoneCount(0);
        //当前小时留存数
        taskStatus.setRemainTaskCount(0);
        taskStatus.setCurrentHourRemainTaskCount(0);
        taskStatus.setCurrentHourRemainDoneCount(0);


        return taskStatus;
    }
}
