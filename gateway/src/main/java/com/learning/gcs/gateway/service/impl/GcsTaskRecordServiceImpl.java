package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTaskRecord;
import com.learning.gcs.common.repository.GcsTaskRecordRepository;
import com.learning.gcs.gateway.service.GcsTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GcsTaskRecordServiceImpl implements GcsTaskRecordService{

    @Autowired
    private GcsTaskRecordRepository gcsTaskRecordRepository;

    @Override
    public GcsTaskRecord save(GcsTaskRecord gcsTaskRecord) {
        return gcsTaskRecordRepository.save(gcsTaskRecord);
    }

    @Override
    public List<GcsTaskRecord> findByTaskIdAndRtAndCreateDate(Integer taskId, String createDate,Integer rt) {
        return gcsTaskRecordRepository.findByTaskIdAndCreateDateAndRt(taskId,createDate,rt);
    }

    @Override
    public Integer updateRtByTaskIdAndImei(Integer taskId, String imei) {
        return gcsTaskRecordRepository.updateRtByTaskIdAndImei(taskId,imei);
    }

    @Override
    public Long countByTaskIdAndImei(Integer taskId, String imei) {
        return gcsTaskRecordRepository.countByTaskIdAndImei(taskId, imei);
    }
}
