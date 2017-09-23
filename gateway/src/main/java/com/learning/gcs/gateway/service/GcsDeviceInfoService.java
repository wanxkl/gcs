package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsDeviceInfo;

public interface GcsDeviceInfoService {

    GcsDeviceInfo  getByTaskId(Integer taskId);

    GcsDeviceInfo save(GcsDeviceInfo gcsDeviceInfo);


}
