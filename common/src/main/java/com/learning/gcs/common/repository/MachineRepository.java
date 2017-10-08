package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.Machine;

public interface MachineRepository extends MyRepository<Machine,Integer>{

    Machine findByMachineName(String machineName);
}
