package com.learning.gcs.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Component;
@Component
public class RedisReader {
    @Autowired
    private RedisTemplate stringRedisTemplate;


    public Object get(String key) {

        return stringRedisTemplate.opsForValue().get(key);
    }

    public Object[] getSetValues(String key) {
        return stringRedisTemplate.opsForSet().members(key).toArray();
    }

    public Integer getAtomic(String key){
        RedisAtomicInteger atomicInteger = new RedisAtomicInteger(key,stringRedisTemplate.getConnectionFactory());
        return  atomicInteger.get();
    }
}
