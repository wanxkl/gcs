package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTaskConfig;

public interface GcsTaskConfigRepository extends MyRepository<GcsTaskConfig,Integer>{

    GcsTaskConfig findOneByOrderByIdDesc();
}
