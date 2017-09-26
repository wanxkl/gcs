package com.learning.gcs.web.Service;

import com.learning.gcs.common.entity.GcsTask;
import sun.security.jgss.GSSCaller;

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
     * @param gcsTask 任务实体
     * @param id 任务id
     * @return 修改是否成功
     */
    boolean updateGcsTaskById(GcsTask gcsTask,int id);

    /**
     * 添加任务
     * @param gcsTask 任务实体
     * @return 添加成功或者失败
     */
    boolean add(GcsTask gcsTask);

    /**
     * t通过id修改任务
     * @param ids 任务id
     * @return 修改结果  true成功
     */
    boolean deleteById(int[] ids);
}
