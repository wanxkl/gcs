package com.learning.gcs.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisReader {

    @Autowired
    private RedisTemplate redisTemplate;

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public Object []  getSetValues(String key){
        return redisTemplate.opsForSet().members(key).toArray();
    }

}
