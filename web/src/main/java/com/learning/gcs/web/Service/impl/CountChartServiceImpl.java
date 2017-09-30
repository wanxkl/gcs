package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.GcsTaskLog;
import com.learning.gcs.common.repository.GcsTaskLogRepository;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.web.Service.CountChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.util.*;

@Service
public class CountChartServiceImpl implements CountChartService{
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private GcsTaskLogRepository gcsTaskLogRepository;
    @Override
    public List findIncreasUsers(String taskName, String time) {
        String starteTime = time+" 00:00:00";
        String endTime = time+" 23:59:59";
        List list = new ArrayList();
        String sql ="SELECT DATE_FORMAT(create_time,'%Y%H') t, COUNT(create_time) counta FROM gcs_task_record  where create_time>='"+starteTime+"' and create_time<='"+endTime+"' ";
        if (taskName!=null&&!"".equals(taskName)){
            sql+=" and task_id='"+taskName+"' ";
        }
        sql+=" GROUP BY t";
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
            sql+=" and task_id='"+taskName+"'";
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
        Collections.reverse(list);
        return list;
    }

    @Override
    public Page findTask(int pageSize,int pageNo) {
        String hql = "from GcsTaskLog order by createTime desc";
        Page page= gcsTaskLogRepository.findByHql(hql,pageSize,pageNo);
        return page;
    }

    @Override
    public List pages(int pageNo,int pageCount) {
        List pageList = new ArrayList();
        if (pageCount<=9){
            for(int i=1;i<=pageCount;i++){
                pageList.add(i);
            }
        }else {
            if (pageNo<=4){
                pageList.add(1);
                pageList.add(2);
                pageList.add(3);
                pageList.add(4);
                pageList.add(5);
                pageList.add(6);
                pageList.add(7);
                pageList.add(8);
                pageList.add(9);
            } else if (pageNo<=pageCount-4&&pageNo>4){
                pageList.add(pageNo-4);
                pageList.add(pageNo-3);
                pageList.add(pageNo-2);
                pageList.add(pageNo-1);
                pageList.add(pageNo);
                pageList.add(pageNo+1);
                pageList.add(pageNo+2);
                pageList.add(pageNo+3);
                pageList.add(pageNo+4);
            }else{
                pageList.add(pageCount-8);
                pageList.add(pageCount-7);
                pageList.add(pageCount-6);
                pageList.add(pageCount-5);
                pageList.add(pageCount-4);
                pageList.add(pageCount-3);
                pageList.add(pageCount-2);
                pageList.add(pageCount-1);
                pageList.add(pageCount);
            }
        }
        return pageList;
    }
}
