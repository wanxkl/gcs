package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTaskConfig;

import java.io.IOException;

public interface GcsTaskConfigService {

    GcsTaskConfig  getGcsTaskConfig() throws IOException;

    void save(GcsTaskConfig gcsTaskConfig);
}
