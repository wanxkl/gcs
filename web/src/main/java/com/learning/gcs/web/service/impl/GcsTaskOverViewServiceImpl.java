package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskOverview;
import com.learning.gcs.common.repository.GcsTaskLogRepository;
import com.learning.gcs.common.repository.GcsTaskOverviewRepository;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.common.util.TimeUtil;
import com.learning.gcs.web.service.GcsTaskOverviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 10:30
 * @description
 */
@Service
public class GcsTaskOverViewServiceImpl implements GcsTaskOverviewService{

    private static final Logger logger = LoggerFactory.getLogger(GcsTaskOverViewServiceImpl.class);

    @Autowired
    private GcsTaskOverviewRepository gcsTaskOverviewRepository;

    @Autowired
    private GcsTaskRepository gcsTaskRepository;

    @Autowired
    private GcsTaskLogRepository gcsTaskLogRepository;

    @Override
    public boolean isExist(String createDate, Integer taskId) {
        return gcsTaskOverviewRepository.countByCreateDateAndTaskId(createDate, taskId)==0?false:true;
    }

    @Override
    public void generateYesterdayData() {
        String createDate = TimeUtil.getFormatDateDistinceNow(1);

        Integer count = batchUpdate(createDate);

        logger.info("开始执行 generateTodayData：{}",count);
    }

    @Override
    public void generateTodayData() {
        String createDate = TimeUtil.getFormatDate();

        Integer count = batchUpdate(createDate);

        logger.info("开始执行 generateTodayData：{}",count);
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
    public Page<GcsTaskOverview> findByPage(int pageSize,int pageNo,GcsTask gcs) {
       /* Sort sort =
        Page page = gcsTaskOverviewRepository.findAll()*/
        return null;
    }
    @Override
    public Integer batchUpdate(String createDate) {
        List<GcsTask> tasks = gcsTaskRepository.findAll();
        for (GcsTask task : tasks) {
            Integer doneCount =  gcsTaskLogRepository.countByCreateDateAndTaskId(createDate,task.getId());
            Integer countTask = gcsTaskOverviewRepository.countByCreateDateAndTaskId(createDate,task.getId());
            if(countTask==0){
                GcsTaskOverview gcsTaskOverview = new GcsTaskOverview();
                gcsTaskOverview.setTaskId(task.getId());
                gcsTaskOverview.setTaskName(task.getAppName());
                gcsTaskOverview.setPlanCount(task.getTaskCount());
                gcsTaskOverview.setDoneCount(doneCount);
                gcsTaskOverview.setCreateDate(createDate);
                gcsTaskOverviewRepository.save(gcsTaskOverview);
            }else {
                gcsTaskOverviewRepository.updateDoneCountByCreateDateAndTaskId(doneCount,createDate,task.getId());
            }
        }
        return tasks.size();
    }
}
