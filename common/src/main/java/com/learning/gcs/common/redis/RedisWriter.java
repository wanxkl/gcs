package com.learning.gcs.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class RedisWriter {
    @Autowired
    private RedisTemplate stringRedisTemplate;



    public void set(String key, Object value, long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    public void set(String key, Object value) {


        stringRedisTemplate.opsForValue().set(key, value);
    }


    public Integer getAndSetAtomic(String key){
        RedisAtomicInteger atomicInteger = new RedisAtomicInteger(key,stringRedisTemplate.getConnectionFactory());
        return  atomicInteger.getAndAdd(1);
    }


    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    void setSet(Object... values) {
        stringRedisTemplate.opsForSet().add(values);
    }

    void deleteSetValue(Object key, Object value) {
        stringRedisTemplate.opsForSet().remove(key, value);
    }

}
