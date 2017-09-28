package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTaskRecord;

import java.util.List;

public interface GcsTaskRecordService {

    GcsTaskRecord save(GcsTaskRecord gcsTaskRecord);

    List<GcsTaskRecord> findByTaskIdAndRtAndCreateDate(Integer taskId, String createDate,Integer rt);
}
