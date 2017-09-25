package com.learning.gcs.web.Service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GcsTaskServiceImpl implements GcsTaskService{
    @Autowired
    private GcsTaskRepository gcsTaskRepository;
    @Override
    public GcsTask findById(int id) {
        return gcsTaskRepository.findOne(id);
    }

    @Override
    public List<GcsTask> finAll() {
        return gcsTaskRepository.findAll();
    }

    @Override
    public boolean updateGcsTaskById(GcsTask gcsTask, int id) {
        return gcsTaskRepository.updateById();
    }

    @Override
    public boolean add(GcsTask gcsTask) {
        gcsTaskRepository.save(gcsTask);
        return true;
    }

    @Override
    public boolean deleteById(int[] ids) {
        int i = 0;
        for (i=0;i<ids.length;i++){
            int id = ids[i];
            gcsTaskRepository.delete(id);
        }
         return true;
    }
}
