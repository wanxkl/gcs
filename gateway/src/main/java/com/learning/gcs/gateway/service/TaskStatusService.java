package com.learning.gcs.gateway.service;

import com.learning.gcs.gateway.bean.TaskStatus;

public interface TaskStatusService {

    TaskStatus getByTaskIdAndHour(Integer taskId,String currentDate, Integer currentHour);

}
