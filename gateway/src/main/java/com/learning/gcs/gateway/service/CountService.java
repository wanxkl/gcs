package com.learning.gcs.gateway.service;

public interface CountService {

    Integer getTaskCount(Integer taskId);

    Integer getTaskCount(Integer taskId,Integer hour);

    Integer getAndSetTaskCount(Integer taskId);

    Integer getAndSetTaskCount(Integer taskId,Integer hour);

    Integer deleteTaskCount(Integer taskId,Integer hour);

    Integer deleteTaskCount();

}
