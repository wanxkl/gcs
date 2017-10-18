package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.Machine;
import com.learning.gcs.common.entity.MachineGroup;
import com.learning.gcs.common.repository.MachineGroupRepository;
import com.learning.gcs.common.repository.MachineRepository;
import com.learning.gcs.web.service.MachineGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MachineGroupServiceImpl implements MachineGroupService {
    @Autowired
    MachineGroupRepository machineGroupRepository;
    @Autowired
    MachineRepository machineRepository;
    @Override
    public List<MachineGroup> findAll() {
        return machineGroupRepository.findAll();
    }

    @Override
    public void deleteGroupMachine(int id) {
        machineGroupRepository.delete(id);
    }

    @Override
    public void addGroup(String groupName,String [] ids) {
        MachineGroup machineGroup = new MachineGroup();
        machineGroup.setGroupName(groupName);
        List<Machine> machines = new ArrayList();
        for(String id:ids){
            Machine machine = machineRepository.findOne(Integer.parseInt(id));
            machines.add(machine);
        }
        machineGroup.setMachines(machines);
        machineGroupRepository.save(machineGroup);
    }

    @Override
    public void deleteMachineGroup(int groupId, int machineId) {
        MachineGroup machineGroup = machineGroupRepository.findOne(groupId);
        List<Machine> machines = machineGroup.getMachinesList();
        for(int i=0;i<machines.size();i++){
            if (machines.get(i).getId()==machineId){
                machines.remove(machines.get(i));
            }
        }
        machineGroup.setMachines(machines);
        machineGroupRepository.delete(groupId);
        machineGroupRepository.save(machineGroup);
    }
}
