package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.gateway.service.GcsTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GcsTaskServiceImpl implements GcsTaskService{


    @Override
    public List<GcsTask> findAll() {
        return null;
    }

    @Override
    public List<Object> getValidTaskIds(String deviceId) {
        return null;
    }

    @Override
    public List<Object> getCurrentTaskIds(Integer taskId) {
        return null;
    }


    @Override
    public GcsTask findByTaskId(Integer taskId) {
        return null;
    }

    @Override
    public GcsTask getByTaskId(Integer taskId) {
        return null;
    }
}
