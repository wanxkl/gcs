package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsDeviceInfo;

import java.io.IOException;

public interface GcsDeviceInfoService {

    GcsDeviceInfo  getByTaskId(Integer taskId);

    GcsDeviceInfo save(GcsDeviceInfo gcsDeviceInfo);

    GcsDeviceInfo get(String imei) throws IOException;
}
