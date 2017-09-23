package com.learning.gcs.gateway.bean;

import com.learning.gcs.common.entity.GcsDeviceInfo;
import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskConfig;

import java.util.LinkedList;
import java.util.List;

public class Task {

    private GcsTaskConfig config;
    private List<GcsTask> taskList;

    private TaskVpn vpn;
    private GcsDeviceInfo info;
    private List<String> blackList;

    public GcsTaskConfig getConfig() {
        return config;
    }

    public void setConfig(GcsTaskConfig config) {
        this.config = config;
    }

    public List<GcsTask> getTaskList() {
        if(taskList==null){
            setTaskList(new LinkedList<GcsTask>());
        }

        return taskList;
    }

    public void setTaskList(List<GcsTask> taskList) {
        this.taskList = taskList;
    }

    public TaskVpn getVpn() {
        if(vpn == null){
            setVpn(new TaskVpn());
        }
        return vpn;
    }

    public void setVpn(TaskVpn vpn) {
        this.vpn = vpn;
    }

    public GcsDeviceInfo getInfo() {
        return info;
    }

    public void setInfo(GcsDeviceInfo info) {
        this.info = info;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }
}
