package com.learning.gcs.gateway.bean;

public class TaskConfig {
    private int version;
    private int runTimeMax;
    private String luaUrl;
    private boolean state;

    public TaskConfig() {
    }

    public TaskConfig(boolean state) {
        this.state = state;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getRunTimeMax() {
        return runTimeMax;
    }

    public void setRunTimeMax(int runTimeMax) {
        this.runTimeMax = runTimeMax;
    }

    public String getLuaUrl() {
        return luaUrl;
    }

    public void setLuaUrl(String luaUrl) {
        this.luaUrl = luaUrl;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
