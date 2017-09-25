package com.learning.gcs.gateway.bean;

public class Result {
    //0 失败  1 成功
    private int status;
    private String message;

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
