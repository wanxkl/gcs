package com.learning.gcs.gateway.adapter;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.gateway.bean.TaskSimple;

public class TaskSimpleAdapter {

    private GcsTask gcsTask;

    public TaskSimpleAdapter(GcsTask gcsTask) {
        this.gcsTask = gcsTask;
    }

    public TaskSimple build(){
        TaskSimple taskSimple = new TaskSimple();
        taskSimple.setTaskId(gcsTask.getId());
        taskSimple.setApkUrl(gcsTask.getApkUrl());
        taskSimple.setAppName(gcsTask.getAppName());
        taskSimple.setPackageName(gcsTask.getPackageName());
        taskSimple.setRunNumber(gcsTask.getRunNumber());
        taskSimple.setTaskMode(gcsTask.getTaskMode());
        return taskSimple;
    }
}
