package com.learning.gcs.gateway.bean;

public class TaskConfig {
    private Integer version;
    private Integer runTimeMax;
    private String luaUrl;
    private Boolean state;
    private String message;
    public TaskConfig() {
    }

    public TaskConfig(Boolean state) {
        this.state = state;
    }
    public TaskConfig(Boolean state,String message) {
        this.state = state;
        this.message = message;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getRunTimeMax() {
        return runTimeMax;
    }

    public void setRunTimeMax(Integer runTimeMax) {
        this.runTimeMax = runTimeMax;
    }

    public String getLuaUrl() {
        return luaUrl;
    }

    public void setLuaUrl(String luaUrl) {
        this.luaUrl = luaUrl;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
