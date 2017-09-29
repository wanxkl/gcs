package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTaskLog;
import com.learning.gcs.common.repository.GcsTaskLogRepository;
import com.learning.gcs.gateway.service.GcsTaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GcsTaskLogServiceImpl implements GcsTaskLogService{
    @Autowired
    private GcsTaskLogRepository gcsTaskLogRepository;

    @Override
    public GcsTaskLog save(GcsTaskLog gcsTaskLog) {
        return gcsTaskLogRepository.save(gcsTaskLog);
    }
}
