package com.learning.gcs.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
@Component
public class RedisWriter {
    @Autowired
    private RedisTemplate stringRedisTemplate;

    public void set(String key, Object value, long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    public void setSet(String key, Object value){
        stringRedisTemplate.opsForSet().add(key,value);
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


    public String rightPop(String key) {
        Object o = stringRedisTemplate.opsForList().rightPop(key);

        if (!ObjectUtils.isEmpty(o)) {
            return o.toString();
        }
        return null;
    }

    public Long leftPush(String key, String... values) {
        Long pushCount = stringRedisTemplate.opsForList().leftPushAll(key, values);

        if (!ObjectUtils.isEmpty(pushCount)) {
            return pushCount;
        }
        return 0L;
    }

    public Integer deleteKeys(String pattern){
        Integer deleteCount = 0;
        Set<String> patternKeySet = stringRedisTemplate.keys(pattern);
        for (String subKey : patternKeySet) {
            stringRedisTemplate.delete(subKey);
            deleteCount++;
        }
        return deleteCount;
    }

}
