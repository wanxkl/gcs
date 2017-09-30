package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.GcsTaskConfig;
import com.learning.gcs.web.Service.GcsTaskConfigService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GcsTaskConfigServiceImpl implements GcsTaskConfigService {
    @Override
    public List<GcsTaskConfig> findNewGcsTaskConfig(int id) {
        return null;
    }

    @Override
    public void updateById(int id) {

    }
}
