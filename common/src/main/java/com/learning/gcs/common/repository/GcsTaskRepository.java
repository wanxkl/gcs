package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.Machine;
import com.learning.gcs.common.entity.MachineGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GcsTaskRepository extends MyRepository<GcsTask,Integer>{
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update GcsTask g set g.appName =:appName,g.apkUrl=:apkUrl,g.runNumber=:runNumber,g.weight=:weight,g.taskModeCode=:taskModeCode,g.taskMode=:taskMode,g.packageName=:packageName,g.marketUrl=:marketUrl,g.marketPackName=:marketPackName,g.searchTxt=:searchTxt,g.findSet=:findSet,g.taskStatus=:taskStatus,g.taskCount=:taskCount,g.newAddRemainCurveId=:newAddRemainCurveId,g.nichijouRemainCurveId=:nichijouRemainCurveId,g.remainCurveId=:remainCurveId,g.group=:group where g.id=:id")
    void updateById(@Param("id")int id,
                    @Param("appName")String appName,
                    @Param("apkUrl")String apkUrl,
                    @Param("runNumber")Integer runNumber,
                    @Param("weight")Integer weight,
                    @Param("taskModeCode")Integer taskModeCode,
                    @Param("taskMode")String taskMode,
                    @Param("packageName")String packageName,
                    @Param("marketUrl")String marketUrl,
                    @Param("marketPackName")String marketPackName,
                    @Param("searchTxt")String searchTxt,
                    @Param("findSet")String findSet,
                    @Param("taskStatus")Integer taskStatus,
                    @Param("taskCount")Integer taskCount,
                    @Param("newAddRemainCurveId")Integer newAddRemainCurveId,
                    @Param("nichijouRemainCurveId")Integer nichijouRemainCurveId,
                    @Param("remainCurveId")Integer remainCurveId,
                    @Param("group")MachineGroup group);


    @Transactional
    @Modifying
    @Query("update GcsTask g set g.taskCount = :taskCount where g.id = :taskId")
    Integer updateTaskCountById(@Param("taskId") Integer taskId,@Param("taskCount") Integer taskCount);


    List<GcsTask> findByTaskStatus(Integer taskStatus);


    List<Integer> findIdByTaskStatusOrderByWeightDesc(Integer taskStatus);
}
