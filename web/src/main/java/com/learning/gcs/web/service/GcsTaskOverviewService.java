package com.learning.gcs.web.service;

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
     * @param createDate        任务日期
     * @param taskId            任务Id
     * @return                  影响数量
     */
    Integer updateByCreateDateAndTaskId(String createDate,Integer taskId);

    /**
     * 根据条件分页查询
     * @param page              分页条件
     * @param gcsTaskOverview   查询条件
     * @return                  分页数据
     */
    Page<GcsTaskOverview> findByPage(Page page,GcsTaskOverview gcsTaskOverview);
}
