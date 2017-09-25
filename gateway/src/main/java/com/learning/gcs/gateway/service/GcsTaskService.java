package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTask;

import java.util.List;

public interface GcsTaskService {

    List<GcsTask> findAll();

    List<Object> getValidTaskIds(String  deviceId);

    List<Object> getCurrentTaskIds(Integer taskId);

    GcsTask findByTaskId(Integer taskId);

    GcsTask getByTaskId(Integer taskId);

    GcsTask save(GcsTask gcsTask);


}
