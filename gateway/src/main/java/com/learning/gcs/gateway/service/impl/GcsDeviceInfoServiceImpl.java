package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsDeviceInfo;
import com.learning.gcs.common.repository.GcsDeviceInfoRepository;
import com.learning.gcs.gateway.service.GcsDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GcsDeviceInfoServiceImpl implements GcsDeviceInfoService{

    @Autowired
    private GcsDeviceInfoRepository gcsDeviceInfoRepository;

    @Override
    public GcsDeviceInfo getByTaskId(Integer taskId) {
        return null;
    }

    @Override
    public GcsDeviceInfo save(GcsDeviceInfo gcsDeviceInfo) {
        return gcsDeviceInfoRepository.save(gcsDeviceInfo);
    }
}
