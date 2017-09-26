package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTask;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GcsTaskRepository extends MyRepository<GcsTask,Integer>{

    @Modifying
    @Transactional
    @Query("update GcsTask g set g.taskCount = :taskCount where g.id = :taskId")
    Integer updateTaskCountById(@Param("taskId") Integer taskId,@Param("taskCount") Integer taskCount);

}
