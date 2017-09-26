package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.gateway.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService{

    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private RedisReader redisReader;
    @Override
    public List<Object> getTaskIdsByDeviceId(String deviceId) {

        Object [] set = redisReader.getSetValues(KeyUtil.generateDeviceIdKey(deviceId));

        return Arrays.asList(set);
    }
}
