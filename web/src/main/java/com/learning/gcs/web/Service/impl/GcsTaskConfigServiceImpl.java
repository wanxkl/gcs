package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskConfig;
import com.learning.gcs.common.repository.GcsTaskConfigRepository;
import com.learning.gcs.web.Service.GcsTaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class GcsTaskConfigServiceImpl implements GcsTaskConfigService {
    @Autowired
    GcsTaskConfigRepository gcsTaskConfigRepository;
    @Override
    public GcsTaskConfig findNewGcsTaskConfig() {
        GcsTaskConfig gcsTaskConfig = gcsTaskConfigRepository.findTopByOrderByCreateTimeDesc();
        return gcsTaskConfig;
    }

    @Override
    public void updateById(int id,String luaUrl,int runTimeMax,int version) {
        gcsTaskConfigRepository.updateById(id,luaUrl,runTimeMax,version);
    }
}
