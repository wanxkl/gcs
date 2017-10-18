package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.GcsTaskOverview;
import com.learning.gcs.web.service.GcsTaskOverviewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 10:30
 * @description
 */
@Service
public class GcsTaskOverViewServiceImpl implements GcsTaskOverviewService{
    @Override
    public void generateYesterdayData() {

    }

    @Override
    public void generateTodayData() {

    }

    @Override
    public GcsTaskOverview save(GcsTaskOverview gcsTaskOverview) {
        return null;
    }

    @Override
    public Integer updateByCreateDateAndTaskId(String createDate, Integer taskId) {
        return null;
    }

    @Override
    public Page<GcsTaskOverview> findByPage(Page page, GcsTaskOverview gcsTaskOverview) {
        return null;
    }
}
