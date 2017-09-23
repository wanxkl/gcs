package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.gateway.bean.Task;
import java.util.List;

public interface TaskService {

    Task get(String deviceId);

    List<GcsTask> getCurrentTaskList();

}
