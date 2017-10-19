package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTaskOverview;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 10:17
 * @description
 */
public interface GcsTaskOverviewRepository extends MyRepository<GcsTaskOverview,Integer>{
    @Transactional
    @Modifying
    @Query("update GcsTaskOverview g set g.doneCount=:doneCount where g.createDate=:createDate and g.taskId=:taskId")
    Integer updateDoneCountByCreateDateAndTaskId(@Param("doneCount") Integer doneCount,@Param("createDate") String createDate,
                                                 @Param("taskId") Integer taskId);

    Integer countByCreateDateAndTaskId(String createDate,Integer taskId);



}
