package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.util.TimeUtil;
import com.learning.gcs.web.service.GcsTaskOverviewService;
import com.learning.gcs.web.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 10:52
 * @description 计划任务实现类
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{

    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Autowired
    private GcsTaskOverviewService gcsTaskOverviewService;

    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void taskByEveryDay() {
        logger.info("开始执行每日任务：{}", TimeUtil.getFormatTime());
        gcsTaskOverviewService.generateYesterdayData();
    }

    @Override
    public void taskByEveryHour() {

    }

    @Scheduled(cron = "0 0/5 * * * ?")
    @Override
    public void taskByEveryFiveMinute() {
        logger.info("开始执行五分钟任务：{}", TimeUtil.getFormatTime());
        gcsTaskOverviewService.generateTodayData();

    }
}
