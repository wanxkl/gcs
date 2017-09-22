package com.learning.gcs.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisWriter {
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key, Object value, long time, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,time,timeUnit);
    }

    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }

}
