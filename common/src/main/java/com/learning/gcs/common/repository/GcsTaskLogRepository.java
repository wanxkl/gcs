package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTaskLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GcsTaskLogRepository extends MyRepository<GcsTaskLog,Integer>{

    @Query("select g.taskId,count(g.id) from GcsTaskLog g where g.createDate=:createDate group by g.taskId")
    List<Object[]> findByCreateDateGroupByTaskId(@Param("createDate") String createDate);

}
