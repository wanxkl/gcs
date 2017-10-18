package com.learning.gcs.web.service;

import com.learning.gcs.common.entity.GcsTask;

import java.util.List;

public interface GcsTaskService {
    /**
     * 通过id查看任务
     * @param id 任务id
     * @return 任务内容实体
     */
    GcsTask findById(int id);

    /**
     * 查看所有内容
     * @return 任务的list
     */
    List<GcsTask> finAll();

    /**
     * 通过id修改任务
     * @param
     * @param id 任务id
     * @return 修改是否成功
     */
    void updateGcsTaskById(Integer id, String appName, String apkUrl, Integer runNumber, Integer weight, Integer taskModeCode, String taskMode, String packageName, String marketUrl, String marketPackName, String searchTxt, String findSet, Integer taskStatus, Integer taskCount, String machineIds, Integer newAddRemainCurveId, Integer nichijouRemainCurveId, Integer remainCurveId);

    /**
     * 添加任务
     * @param gcsTask 任务实体
     *
     */
    void add(GcsTask gcsTask);

    /**
     * t通过id修改任务
     * @param id 任务id
     *
     */
    void deleteById(int id);
}
