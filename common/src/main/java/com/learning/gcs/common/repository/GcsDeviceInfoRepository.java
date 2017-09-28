package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsDeviceInfo;

public interface GcsDeviceInfoRepository extends MyRepository<GcsDeviceInfo,String>{

    GcsDeviceInfo findByImei(String imei);
}
