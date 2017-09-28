package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTaskRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GcsTaskRecordRepository extends MyRepository<GcsTaskRecord,Integer>{

    List<GcsTaskRecord> findByTaskIdAndCreateDateAndRt(Integer taskId,String createDate,Integer rt);

    @Transactional
    @Modifying
    @Query("update GcsTaskRecord g set g.rt = :rt where g.taskId =:taskId and g.imei = :imei")
    Integer updateRtByTaskIdAndImei(@Param("rt") Integer rt, @Param("taskId") Integer taskId,@Param("imei") String imei);

}
