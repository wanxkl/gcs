package com.learning.gcs.gateway.service;

import java.util.List;

public interface MachineService {
    
    List<Object> getTaskIdsByDeviceId(String deviceId);

}
