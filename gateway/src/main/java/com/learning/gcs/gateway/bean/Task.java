package com.learning.gcs.gateway.bean;

import com.learning.gcs.common.entity.GcsDeviceInfo;

import java.util.LinkedList;
import java.util.List;

public class Task {
    private TaskConfig config;
    private List<TaskSimple> taskList;
    private TaskVpn vpn;
    private GcsDeviceInfo info;
    private List<String> blackList;

    public TaskConfig getConfig() {
        return config;
    }

    public void setConfig(TaskConfig config) {
        this.config = config;
    }

    public List<TaskSimple> getTaskList() {
        if(taskList==null){
            setTaskList(new LinkedList<TaskSimple>());
        }

        return taskList;
    }

    public void setTaskList(List<TaskSimple> taskList) {
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
        if(blackList==null){
            blackList = new LinkedList<>();
            blackList.add("com.android.chrome");
        }
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }
}
