package com.learning.gcs.web.service;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskOverview;
import org.springframework.data.domain.Page;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 10:22
 * @description 任务总览service接口
 */
public interface GcsTaskOverviewService {
    /**
     * 指定日期和任务Id的总览是否存在
     * @param createDate        创建日期
     * @param taskId            任务Id
     * @return                  true:存在 false:不存在
     */
    boolean isExist(String createDate,Integer taskId);
    /**
     *                          生成昨日数据
     *
     */
    void generateYesterdayData();

    /**
     *                          生成今日数据
     *
     */
    void generateTodayData();

    /**
     * 保存数据
     * @param gcsTaskOverview   任务总览对象
     * @return  任务总览对象
     */
    GcsTaskOverview save(GcsTaskOverview gcsTaskOverview);

    /**
     * 根据 任务日期和任务Id      更新任务总览
     * @param doneCount         完成任务数
     * @param createDate        任务日期
     * @param taskId            任务Id
     * @return                  影响数量
     */
    Integer updateByCreateDateAndTaskId(Integer doneCount, String createDate,Integer taskId);

    /**
     * 分页查询
     * @param pageSize 每页显示数
     * @param pageNo 页码
     * @return
     */
    Page<GcsTaskOverview> findByPage(int pageSize, int pageNo, GcsTask gcsTask);

    /**
     * 批量生成指定日期数据
     * @param createDate    指定日期
     * @return  结果数
     */
    Integer batchUpdate(String createDate);
}
