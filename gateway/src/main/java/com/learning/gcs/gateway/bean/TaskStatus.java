package com.learning.gcs.gateway.bean;

public class TaskStatus {
    private Integer taskId;
    private String taskName;

    private String  currentDate;
    private Integer currentHour;

    //当前小时计划
    private Integer planTaskCount;
    private Integer currentHourPlanTaskCount;
    private Integer currentHourPlanDoneCount;
    //当前小时留存
    private Integer remainTaskCount;
    private Integer currentHourRemainTaskCount;
    private Integer currentHourRemainDoneCount;
    //未完成：0 已完成：1
    private Integer done = 0;


    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getCurrentHour() {
        return currentHour;
    }

    public void setCurrentHour(Integer currentHour) {
        this.currentHour = currentHour;
    }

    public Integer getPlanTaskCount() {
        return planTaskCount;
    }

    public void setPlanTaskCount(Integer planTaskCount) {
        this.planTaskCount = planTaskCount;
    }

    public Integer getCurrentHourPlanTaskCount() {
        return currentHourPlanTaskCount;
    }

    public void setCurrentHourPlanTaskCount(Integer currentHourPlanTaskCount) {
        this.currentHourPlanTaskCount = currentHourPlanTaskCount;
    }

    public Integer getCurrentHourPlanDoneCount() {
        return currentHourPlanDoneCount;
    }

    public void setCurrentHourPlanDoneCount(Integer currentHourPlanDoneCount) {
        this.currentHourPlanDoneCount = currentHourPlanDoneCount;
    }

    public Integer getRemainTaskCount() {
        return remainTaskCount;
    }

    public void setRemainTaskCount(Integer remainTaskCount) {
        this.remainTaskCount = remainTaskCount;
    }

    public Integer getCurrentHourRemainTaskCount() {
        return currentHourRemainTaskCount;
    }

    public void setCurrentHourRemainTaskCount(Integer currentHourRemainTaskCount) {
        this.currentHourRemainTaskCount = currentHourRemainTaskCount;
    }

    public Integer getCurrentHourRemainDoneCount() {
        return currentHourRemainDoneCount;
    }

    public void setCurrentHourRemainDoneCount(Integer currentHourRemainDoneCount) {
        this.currentHourRemainDoneCount = currentHourRemainDoneCount;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

}
