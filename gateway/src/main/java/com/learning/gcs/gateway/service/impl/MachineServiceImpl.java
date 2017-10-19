package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.Machine;
import com.learning.gcs.common.entity.MachineGroup;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.MachineRepository;
import com.learning.gcs.gateway.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Set;

@Service
public class MachineServiceImpl implements MachineService{

    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private RedisReader redisReader;
    @Autowired
    private MachineRepository machineRepository;
    @Override
    public Set<Object> getTaskIdsByDeviceId(String deviceId) {

        Set<Object> set = redisReader.getSetValues(KeyUtil.generateDeviceIdKey(deviceId));

        if(ObjectUtils.isEmpty(set)){
            Machine machine =machineRepository.findByMachineName(deviceId);
            List<MachineGroup> groups = machine.getMachineGroups();
            for (MachineGroup group : groups) {
                for (GcsTask gcsTask : group.getGcsTasks()) {
                    String key = KeyUtil.generateDeviceIdKey(deviceId);
                    redisWriter.setSet(key,gcsTask.getId()+"");
                }
            }
            return redisReader.getSetValues(KeyUtil.generateDeviceIdKey(deviceId));
        }
        return set;
    }

    @Override
    public void save(Machine machine) {
        machineRepository.save(machine);
    }

    @Override
    public List<Machine> findAll() {
        return machineRepository.findAll();
    }
}
