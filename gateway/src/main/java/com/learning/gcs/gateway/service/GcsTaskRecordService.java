package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTaskRecord;
import com.learning.gcs.gateway.bean.Task;

import java.util.List;

public interface GcsTaskRecordService {

    GcsTaskRecord save(GcsTaskRecord gcsTaskRecord);

    List<GcsTaskRecord> findByTaskIdAndRtAndCreateDate(Integer taskId, String createDate,Integer rt);

    List<GcsTaskRecord> findByTaskIdAndCreateDate(Integer taskId, String createDate);

    Integer updateRtByTaskIdAndImei(Integer taskId,String imei);

    Long countByTaskIdAndImei(Integer taskId,String imei);
}
