package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.repository.GcsTaskRepository;
import com.learning.gcs.gateway.service.GcsTaskService;
import com.learning.gcs.gateway.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GcsTaskServiceImpl implements GcsTaskService {
    private List<Object> list;
    @Autowired
    private GcsTaskRepository gcsTaskRepository;
    @Autowired
    private MachineService    machineService;
    @Override
    public List<GcsTask> findAll() {
        return gcsTaskRepository.findAll();
    }

    @Override
    public List<Integer> getValidTaskIds(String deviceId) {
        List<Integer> list = null;
        List<GcsTask> gcsTasks = gcsTaskRepository.findByTaskStatus(1);
        if (!ObjectUtils.isEmpty(gcsTasks)) {
            Set<Object> set = machineService.getTaskIdsByDeviceId(deviceId);
            if (!ObjectUtils.isEmpty(set)) {
                list = new ArrayList<>();
                for (GcsTask gcsTask : gcsTasks) {
                    if (set.contains(gcsTask.getId()+"")) {
                        list.add(gcsTask.getId());
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<Integer> getCurrentTaskIds(Integer taskId) {
        return gcsTaskRepository.findIdByTaskStatusOrderByWeightDesc(1);
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
    public Integer updateTaskCountById(Integer taskId, Integer taskCount) {
        Integer changedCount = gcsTaskRepository.updateTaskCountById(taskId, taskCount);


        if (changedCount > 0) {
        }
        return changedCount;
    }
}
