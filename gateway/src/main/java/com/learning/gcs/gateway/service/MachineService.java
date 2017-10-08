package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.Machine;

import java.util.List;
import java.util.Set;

public interface MachineService {
    
    Set<Object> getTaskIdsByDeviceId(String deviceId);

    void save(Machine machine);

    List<Machine> findAll();
}
