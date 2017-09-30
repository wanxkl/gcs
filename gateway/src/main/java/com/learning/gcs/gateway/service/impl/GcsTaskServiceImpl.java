package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.gateway.service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class GcsTaskServiceImpl implements GcsTaskService{

    private List<Object> list;

    @Autowired
    private GcsTaskRepository gcsTaskRepository;

    @Autowired
    private RedisWriter redisWriter;

    @Override
    public List<GcsTask> findAll() {
        return gcsTaskRepository.findAll();
    }

    @Override
    public List<Object> getValidTaskIds(String deviceId) {
      /*  //TODO 这里需要计算出可用的任务ID
        if(ObjectUtils.isEmpty(list)){
            list = new LinkedList<>();
            list.add(1);
        }*/

        List<Object>  list = null;
        List<GcsTask> gcsTasks = gcsTaskRepository.findByTaskStatus(1);
        if(!ObjectUtils.isEmpty(gcsTasks)){
            list = new ArrayList<>();
            for (GcsTask gcsTask : gcsTasks) {
                list.add(gcsTask.getId());
            }
        }

        return list;
    }

    @Override
    public List<Object> getCurrentTaskIds(Integer taskId) {
        return null;
    }


    @Override
    public GcsTask findByTaskId(Integer taskId) {
        return null;
    }

    @Override
    public GcsTask getByTaskId(Integer taskId) {
        return gcsTaskRepository.findOne(taskId);
    }

    @Override
    public GcsTask save(GcsTask gcsTask) {
        return gcsTaskRepository.save(gcsTask);
    }

    @Override
    public Integer updateTaskCountById(Integer taskId,Integer taskCount) {
        Integer changedCount = gcsTaskRepository.updateTaskCountById(taskId,taskCount);


        if(changedCount > 0){
        }
        return changedCount;
    }
}
