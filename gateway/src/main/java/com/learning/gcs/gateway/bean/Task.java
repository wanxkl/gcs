package com.learning.gcs.gateway.bean;

import java.util.List;

public class Task {

    private TaskConfig config;
    private List<TaskSimple> taskList;
    private TaskVpn vpn;
    private TaskInfo info;
    private List<String> blackList;

    public TaskConfig getConfig() {
        return config;
    }

    public void setConfig(TaskConfig config) {
        this.config = config;
    }

    public List<TaskSimple> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskSimple> taskList) {
        this.taskList = taskList;
    }

    public TaskVpn getVpn() {
        return vpn;
    }

    public void setVpn(TaskVpn vpn) {
        this.vpn = vpn;
    }

    public TaskInfo getInfo() {
        return info;
    }

    public void setInfo(TaskInfo info) {
        this.info = info;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }
}
