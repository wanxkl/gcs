package com.learning.gcs.gateway.bean;

public class TaskSimple {

    private int taskId;
    private String TaskMode;
    private String appName;
    private String packageName;
    private String apkUrl;
    private int runNumber;
    private String userName;
    private String userPassword;
    //market
    private String marketName;
    private String marketUrl;
    private String marketPackageName;
    private String searchTxt;
    private FindSet findSet;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskMode() {
        return TaskMode;
    }

    public void setTaskMode(String taskMode) {
        TaskMode = taskMode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public int getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(int runNumber) {
        this.runNumber = runNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketUrl() {
        return marketUrl;
    }

    public void setMarketUrl(String marketUrl) {
        this.marketUrl = marketUrl;
    }

    public String getMarketPackageName() {
        return marketPackageName;
    }

    public void setMarketPackageName(String marketPackageName) {
        this.marketPackageName = marketPackageName;
    }

    public String getSearchTxt() {
        return searchTxt;
    }

    public void setSearchTxt(String searchTxt) {
        this.searchTxt = searchTxt;
    }

    public FindSet getFindSet() {
        return findSet;
    }

    public void setFindSet(FindSet findSet) {
        this.findSet = findSet;
    }
}
