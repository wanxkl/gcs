package com.learning.gcs.web.Service.impl;

import com.learning.gcs.web.Service.CountChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.util.*;

@Service
public class CountChartServiceImpl implements CountChartService{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List findIncreasUsers(String taskName, String time) {
        String starteTime = time+" 00:00:00";
        String endTime = time+" 23:59:59";
        List list = new ArrayList();
        String sql ="SELECT DATE_FORMAT(create_time,'%Y%H'), COUNT(create_time) counta FROM gcs_task_record  where create_time>='"+starteTime+"' and create_time<='"+endTime+"' ";
        if (taskName!=null&&!"".equals(taskName)){
            sql+=" and taskId='"+taskName+"' ";
        }
        sql+=" GROUP BY create_time";
        //System.out.println(sql);
        javax.persistence.Query query = entityManager.createNativeQuery(sql);
        List chartY = query.getResultList();
        Iterator it = chartY.iterator();
        while (it.hasNext()){
            //System.out.println(it.next());
            Object[] object =(Object[]) it.next();
            list.add(Integer.parseInt(object[1].toString()));
            //System.out.println(object[1].toString());
        }
        return list;
    }

    @Override
    public List findRemainUsers(String taskName, String time) {
        String starteTime = time+" 00:00:00";
        String endTime = time+" 23:59:59";
        List list = new ArrayList();
        String sql ="SELECT rt, COUNT(rt) FROM gcs_task_record WHERE create_time>='"+starteTime+"' and create_time<='"+endTime+"' ";
        //System.out.println(sql);
        if (taskName!=null&&!"".equals(taskName)){
            sql+=" and taskName='"+taskName+"'";
        }
        sql+=" group by rt";
        javax.persistence.Query query = entityManager.createNativeQuery(sql);
        List chartY = query.getResultList();
        int i = 0;
        int sum = 0;
        Collections.reverse(chartY);
        Iterator it = chartY.iterator();
        while (it.hasNext()){
            Object[] object =(Object[]) it.next();
            sum+=Integer.parseInt(object[1].toString());
            list.add(sum);
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }
}