package com.learning.gcs.web.Service;

import java.util.List;

public interface CountChartService {
    /**
     * 按小时查询新增用户数
     * @param taskName 任务名称
     * @param time 任务时间
     * @return 用户数集合
     */
    public List<Integer> findIncreasUsers(String taskName,String time);
}
