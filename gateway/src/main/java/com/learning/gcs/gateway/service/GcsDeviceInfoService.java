package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsDeviceInfo;

import java.io.IOException;
import java.util.List;

public interface GcsDeviceInfoService {

    GcsDeviceInfo  getByTaskId(Integer taskId);

    GcsDeviceInfo save(GcsDeviceInfo gcsDeviceInfo);

    GcsDeviceInfo get(String imei) throws IOException;

    List<GcsDeviceInfo> findAll();

    GcsDeviceInfo findById(String imei);
}
