package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.MachineGroup;
import com.learning.gcs.common.repository.MachineGroupRepository;
import com.learning.gcs.web.Service.MachineGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MachineGroupServiceImpl implements MachineGroupService {
    @Autowired
    MachineGroupRepository machineGroupRepository;
    @Override
    public List<MachineGroup> findAll() {
        return machineGroupRepository.findAll();
    }
}
