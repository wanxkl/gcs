package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTask;

import java.util.List;

public interface GcsTaskRepository extends MyRepository<GcsTask,Integer>{
    @Override
    List<GcsTask> findAll();
}
