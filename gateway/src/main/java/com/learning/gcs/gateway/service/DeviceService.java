package com.learning.gcs.gateway.service;

import java.util.List;

public interface DeviceService {

    List<Object> getTaskIdsByDeviceId(String deviceId);

}
