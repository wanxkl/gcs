package com.learning.gcs.gateway.adapter;
import com.learning.gcs.common.entity.GcsTaskConfig;
import com.learning.gcs.gateway.bean.TaskConfig;

public class TaskConfigAdapter {

    private GcsTaskConfig gcsTaskConfig;

    public TaskConfigAdapter(GcsTaskConfig gcsTaskConfig) {
        this.gcsTaskConfig = gcsTaskConfig;
    }

    public TaskConfig build(){
        TaskConfig taskConfig = new TaskConfig();
        taskConfig.setVersion(gcsTaskConfig.getVersion());
        taskConfig.setLuaUrl(gcsTaskConfig.getLuaUrl());
        taskConfig.setRunTimeMax(gcsTaskConfig.getRunTimeMax());
        taskConfig.setState(gcsTaskConfig.isState());
        return taskConfig;
    }
}
