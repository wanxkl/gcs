package com.learning.gcs.web.service;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 10:35
 * @description
 */
public interface ScheduleService {
    /**
     * 每天执行一次，次日0点执行
     */
    void taskByEveryDay();
    /**
     * 每小时执行一次，次小时00分执行
     */
    void taskByEveryHour();
    /**
     *每五分钟执行一次 没有准确的开始时间
     */
    void taskByEveryFiveMinute();

}
