package com.learning.gcs.web.Service.impl;

import com.learning.gcs.web.Service.CountChartService;

import java.util.ArrayList;
import java.util.List;

public class CountChartServiceImpl implements CountChartService{
    @Override
    public List findIncreasUsers(String taskName, String time) {
        List list = new ArrayList();
        String sql ="SELECT DATE_FORMAT(create_time,'%Y%H'), COUNT(create_time) counta FROM gcs_task_record GROUP BY create_time where crea";
        if (taskName!=null&&"".equals(taskName)){
            sql+="taskId="+taskName;
        }
        
        return null;
    }
}
