package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTaskRecord;
import com.learning.gcs.common.repository.GcsTaskRecordRepository;
import com.learning.gcs.gateway.service.GcsTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GcsTaskRecordServiceImpl implements GcsTaskRecordService{

    @Autowired
    private GcsTaskRecordRepository gcsTaskRecordRepository;

    @Override
    public GcsTaskRecord save(GcsTaskRecord gcsTaskRecord) {
        return gcsTaskRecordRepository.save(gcsTaskRecord);
    }
}
