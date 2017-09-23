package com.learning.gcs.gateway.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.GcsTaskConfig;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.GcsTaskConfigRepository;
import com.learning.gcs.gateway.service.GcsTaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GcsTaskConfigServiceImpl implements GcsTaskConfigService {

    @Autowired
    private GcsTaskConfigRepository gcsTaskConfigRepository;
    @Autowired
    private RedisReader redisReader;
    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GcsTaskConfig getGcsTaskConfig(){
        GcsTaskConfig gcsTaskConfig = null;
        Object o  = redisReader.get(KeyUtil.KEY_TASK_CONFIG);

        if(o==null){
            gcsTaskConfig = gcsTaskConfigRepository.findOneByOrderByIdDesc();
            try {
                redisWriter.set(KeyUtil.KEY_TASK_CONFIG,objectMapper.writeValueAsBytes(gcsTaskConfig));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else{
            try {
                gcsTaskConfig = objectMapper.readValue(o.toString(),GcsTaskConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return gcsTaskConfig;
    }

    @Override
    public void save(GcsTaskConfig gcsTaskConfig) {
        gcsTaskConfigRepository.save(gcsTaskConfig);
        //清楚缓存
        redisWriter.delete(KeyUtil.KEY_TASK_CONFIG);
    }
}
