package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.gateway.service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GcsTaskServiceImpl implements GcsTaskService{
    @Autowired
    private GcsTaskRepository gcsTaskRepository;

    @Override
    public List<GcsTask> findAll() {
        return gcsTaskRepository.findAll();
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
