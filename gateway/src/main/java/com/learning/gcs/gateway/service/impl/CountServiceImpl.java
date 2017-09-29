package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.gateway.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService{

    @Autowired
    private RedisWriter redisWriter;

    @Autowired
    private RedisReader redisReader;

    @Override
    public Integer getTaskCount(Integer taskId) {
        return redisReader.getAtomic(KeyUtil.generateRemainTaskIdCountKey(taskId));
    }

    @Override
    public Integer getTaskCount(Integer taskId, Integer hour) {
        return redisReader.getAtomic(KeyUtil.generateRemainTaskIdHourCountKey(taskId, hour));
    }

    @Override
    public Integer getAndSetTaskCount(Integer taskId) {
        return redisWriter.getAndSetAtomic(KeyUtil.generateRemainTaskIdCountKey(taskId));
    }

    @Override
    public Integer getAndSetTaskCount(Integer taskId, Integer hour) {
        return redisWriter.getAndSetAtomic(KeyUtil.generateRemainTaskIdHourCountKey(taskId,hour));
    }

    @Override
    public Integer deleteTaskCount(Integer taskId, Integer hour) {
        return null;
    }

    @Override
    public Integer deleteTaskCount() {
        Integer deleteCount = redisWriter.deleteKeys(KeyUtil.KEYS_PATTERN_TASKID_COUNT);
        return deleteCount;
    }
}
