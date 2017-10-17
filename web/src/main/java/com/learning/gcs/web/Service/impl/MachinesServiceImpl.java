package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.Machine;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.common.repository.MachineRepository;
import com.learning.gcs.web.Service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MachinesServiceImpl implements MachineService {
    @Autowired
    MachineRepository machineRepository;
    @Autowired
    GcsTaskRepository gcsTaskRepository;
    @Override
    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    @Override
    public Page<Machine> findByPage(int pageSize,int pageNo) {
        String hql = "from Machine";
        return machineRepository.findByHql(hql,pageSize,pageNo);
    }

    @Override
    public void addMachine(String machineName,int liveState) {
        Machine machine = new Machine();
        machine.setMachineName(machineName);
        machine.setLiveStatus(liveState);

        machineRepository.save(machine);
    }
}
