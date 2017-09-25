package com.learning.gcs.gateway.bean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxDeviceInfoBean {

    private String index;

    private MxDeviceInfo devicesInfo;

    private List<Object> userInfo;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public MxDeviceInfo getDevicesInfo() {
        return devicesInfo;
    }

    public void setDevicesInfo(MxDeviceInfo devicesInfo) {
        this.devicesInfo = devicesInfo;
    }

    public List<Object> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<Object> userInfo) {
        this.userInfo = userInfo;
    }
}
