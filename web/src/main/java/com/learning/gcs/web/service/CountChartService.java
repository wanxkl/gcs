package com.learning.gcs.web.service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface CountChartService {
    /**
     * 按小时查询新增用户数
     * @param taskName 任务名称
     * @param time 任务时间
     * @return 用户数集合
     */
     List<Integer> findIncreasUsers(String taskName,String time);

    /**
     * 查询留存数据
     * @param taskName 任务名称
     * @param time 任务时间
     * @return 用户留存集合
     */
    List<Integer> findRemainUsers(String taskName,String time);

    /**
     *
     * @return 任务集合
     */
    Page findTask(int pageSize, int pageNo);

    /**
     * 获取页码
     * @param pageNo
     * @param pageCount
     * @return
     */
    List pages(int pageNo,int pageCount);

}
