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
    public void updateGcsTaskById(Integer id, String appName, String apkUrl, Integer runNumber, Integer weight, Integer taskModeCode, String taskMode, String packageName, String marketUrl, String marketPackName, String searchTxt, String findSet, Integer taskStatus, Integer taskCount, String machineIds, Integer newAddRemainCurveId, Integer nichijouRemainCurveId, Integer remainCurveId) {
        gcsTaskRepository.updateById(id,appName,apkUrl,runNumber,weight,taskModeCode,taskMode,packageName,marketUrl,marketPackName,searchTxt,findSet,taskStatus,taskCount,machineIds,newAddRemainCurveId,nichijouRemainCurveId,remainCurveId);
    }

    @Override
    public void add(GcsTask gcsTask) {
        gcsTaskRepository.save(gcsTask);
    }

    @Override
    public void deleteById(int id) {
        gcsTaskRepository.delete(id);
    }
}
