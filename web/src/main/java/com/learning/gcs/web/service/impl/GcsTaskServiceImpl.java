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
import org.apache.log4j.Logger;
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

    private Logger logger = Logger.getLogger(GcsTaskServiceImpl.class);
    @Override
    public GcsTask findById(int id) {
        GcsTask gcsTask = gcsTaskRepository.findOne(id);
        return gcsTask ;
    }
    @Autowired
    private RedisWriter redisWriter;

    @Override
    public List<GcsTask> finAll() {
        return gcsTaskRepository.findAll();
    }

    @Override
    public void updateGcsTaskById(Integer id, String appName, String apkUrl, Integer runNumber, Integer weight, Integer taskModeCode, String taskMode, String packageName, String marketUrl, String marketPackName, String searchTxt, String findSet, Integer taskStatus, Integer taskCount, Integer newAddRemainCurveId, Integer nichijouRemainCurveId, Integer remainCurveId, int groupId) {
        MachineGroup group = machineGroupRepository.findOne(groupId);
        gcsTaskRepository.updateById(id,appName,apkUrl,runNumber,weight,taskModeCode,taskMode,packageName,marketUrl,marketPackName,searchTxt,findSet,taskStatus,taskCount,newAddRemainCurveId,nichijouRemainCurveId,remainCurveId,group);
        redisWriter.deleteKeys(KeyUtil.generateDeviceIdKey("*"));
    }

    @Override
    public void add(GcsTask gcsTask,int groupId) {
        MachineGroup machineGroup = machineGroupRepository.findOne(groupId);

        gcsTask.setGroup(machineGroup);
        gcsTaskRepository.save(gcsTask);
        redisWriter.deleteKeys(KeyUtil.generateDeviceIdKey("*"));
    }

    @Override
    public void deleteById(int id) {
        gcsTaskRepository.delete(id);
        redisWriter.deleteKeys(KeyUtil.generateDeviceIdKey("*"));
    }
}
