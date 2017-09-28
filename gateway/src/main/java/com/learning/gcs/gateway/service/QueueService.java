package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsDeviceInfo;

import java.io.IOException;

/**
 * 留存用户队列
 */
public interface QueueService {

    //从任务队列中获取任务的设备信息
    GcsDeviceInfo getDeviceInfoByTaskId(Integer taskId) throws IOException;

    //通过任务ID和小时生成队列
    Integer generateQueueByTaskIdAndHour(Integer taskId,Integer hour) throws IOException;

}
