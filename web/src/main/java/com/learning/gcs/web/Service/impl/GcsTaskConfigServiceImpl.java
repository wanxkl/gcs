package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.GcsTaskConfig;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.GcsTaskConfigRepository;
import com.learning.gcs.web.Service.GcsTaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GcsTaskConfigServiceImpl implements GcsTaskConfigService {
    @Autowired
    GcsTaskConfigRepository gcsTaskConfigRepository;

    @Autowired
    private RedisWriter redisWriter;

    @Override
    public GcsTaskConfig findNewGcsTaskConfig() {
        GcsTaskConfig gcsTaskConfig = gcsTaskConfigRepository.findTopByOrderByCreateTimeDesc();
        return gcsTaskConfig;
    }

    @Override
    public void updateById(int id,String luaUrl,int runTimeMax,int version) {
        redisWriter.delete(KeyUtil.KEY_TASK_CONFIG);
        gcsTaskConfigRepository.updateById(id,luaUrl,runTimeMax,version);
    }
}
