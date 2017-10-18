package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.Machine;
import com.learning.gcs.common.entity.MachineGroup;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.common.repository.MachineGroupRepository;
import com.learning.gcs.common.repository.MachineRepository;
import com.learning.gcs.web.service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GcsTaskServiceImpl implements GcsTaskService{
    @Autowired
    private GcsTaskRepository gcsTaskRepository;
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private MachineGroupRepository machineGroupRepository;
    @Override
    public GcsTask findById(int id) {
        return gcsTaskRepository.findOne(id);
    }
    @Autowired
    private RedisWriter redisWriter;

    @Override
    public List<GcsTask> finAll() {
        return gcsTaskRepository.findAll();
    }

    @Override
    public void updateGcsTaskById(Integer id, String appName, String apkUrl, Integer runNumber, Integer weight, Integer taskModeCode, String taskMode, String packageName, String marketUrl, String marketPackName, String searchTxt, String findSet, Integer taskStatus, Integer taskCount, String machineIds, Integer newAddRemainCurveId, Integer nichijouRemainCurveId, Integer remainCurveId) {
        GcsTask gcsTask = gcsTaskRepository.findOne(id);
        List<GcsTask> gcsTasks = new ArrayList<>();
        gcsTasks.add(gcsTask);
        List<Machine> machines = machineRepository.findAll();
        List<Machine> machines2 = new ArrayList();
        Machine machine = new Machine();
        for (int i=0;i<machines.size();i++){
            machine = machines.get(i);
            machine.setGcsTasks(gcsTasks);
            machines2.add(machine);
        }
        gcsTaskRepository.updateById(id,appName,apkUrl,runNumber,weight,taskModeCode,taskMode,packageName,marketUrl,marketPackName,searchTxt,findSet,taskStatus,taskCount,machineIds,newAddRemainCurveId,nichijouRemainCurveId,remainCurveId,machines2);
        redisWriter.deleteKeys(KeyUtil.generateDeviceIdKey("*"));

    }

    @Override
    public void add(GcsTask gcsTask,int groupId) {
        MachineGroup machineGroup = machineGroupRepository.findOne(groupId);
        List<Machine> machines = new ArrayList<>();
        for (Machine machine:machineGroup.getMachinesList()){
            machines.add(machine);
        }
        gcsTask.setMachines(machines);
        gcsTaskRepository.save(gcsTask);
        redisWriter.deleteKeys(KeyUtil.generateDeviceIdKey("*"));
    }

    @Override
    public void deleteById(int id) {
        gcsTaskRepository.delete(id);
        redisWriter.deleteKeys(KeyUtil.generateDeviceIdKey("*"));
    }
}
