package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.GcsTaskOverview;
import com.learning.gcs.common.repository.GcsTaskOverviewRepository;
import com.learning.gcs.web.service.GcsTaskOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GcsTaskOverviewRepository gcsTaskOverviewRepository;

    @Override
    public boolean isExist(String createDate, Integer taskId) {
        return gcsTaskOverviewRepository.countByCreateDateAndTaskId(createDate, taskId)==0?false:true;
    }

    @Override
    public void generateYesterdayData() {

    }

    @Override
    public void generateTodayData() {

    }

    @Override
    public GcsTaskOverview save(GcsTaskOverview gcsTaskOverview) {
        return gcsTaskOverviewRepository.save(gcsTaskOverview);
    }

    @Override
    public Integer updateByCreateDateAndTaskId(Integer doneCount,String createDate, Integer taskId) {
        return gcsTaskOverviewRepository.updateDoneCountByCreateDateAndTaskId(doneCount,createDate,taskId);
    }

    @Override
    public Page<GcsTaskOverview> findByPage(Page page, GcsTaskOverview gcsTaskOverview) {
        return null;
    }
}
