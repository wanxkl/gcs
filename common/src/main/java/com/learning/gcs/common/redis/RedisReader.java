package com.learning.gcs.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisReader {

    @Autowired
    private RedisTemplate redisTemplate;

    Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

}
