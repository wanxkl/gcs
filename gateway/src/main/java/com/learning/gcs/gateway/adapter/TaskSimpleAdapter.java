package com.learning.gcs.gateway.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.gateway.bean.FindSet;
import com.learning.gcs.gateway.bean.TaskSimple;
import com.learning.gcs.gateway.util.Constant;

import java.io.IOException;

public class TaskSimpleAdapter {

    private GcsTask gcsTask;

    public TaskSimpleAdapter(GcsTask gcsTask) {
        this.gcsTask = gcsTask;
    }

    public TaskSimple build() throws IOException {
        TaskSimple taskSimple = new TaskSimple();
        taskSimple.setTaskId(gcsTask.getId());
        taskSimple.setApkUrl(gcsTask.getApkUrl());
        taskSimple.setAppName(gcsTask.getAppName());
        taskSimple.setPackageName(gcsTask.getPackageName());
        taskSimple.setRunNumber(gcsTask.getRunNumber());
        taskSimple.setTaskMode(gcsTask.getTaskMode());
        if(Constant.GCS_TASK_MODE_CODE_MARKET==gcsTask.getTaskModeCode()){
            taskSimple.setMarketName(gcsTask.getMarketName());
            taskSimple.setMarketUrl(gcsTask.getMarketUrl());
            taskSimple.setMarketPackageName(gcsTask.getMarketPackName());
            taskSimple.setSearchTxt(gcsTask.getSearchTxt());
            taskSimple.setFindSet(new ObjectMapper().readValue(gcsTask.getFindSet(),FindSet.class));
        }

        return taskSimple;
    }
}
