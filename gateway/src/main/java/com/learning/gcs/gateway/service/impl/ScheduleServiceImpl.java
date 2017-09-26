package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.gateway.service.ScheduleService;
import com.learning.gcs.gateway.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
public class ScheduleServiceImpl implements ScheduleService{
    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    //每天0点执行
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void clearTaskHourCount() {
        logger.info("开始清空TaskHourCount:{}", TimeUtil.getFormatDate());
    }
}
