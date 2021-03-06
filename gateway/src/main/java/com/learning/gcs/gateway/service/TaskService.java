package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskRecord;
import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;

import java.io.IOException;
import java.util.List;

public interface TaskService {

    Task get(String deviceId) throws IOException;

    List<GcsTask> getCurrentTaskList();

    Result saveGcsTaskRecord(GcsTaskRecord gcsTaskRecord);


    Result saveGcsTaskRecord(String deviceId,String imei,int taskId,int rt);


    Boolean isAddUser(Integer taskId,String addUser);
}
