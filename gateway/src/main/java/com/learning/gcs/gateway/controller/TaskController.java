package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import com.learning.gcs.gateway.bean.TaskConfig;
import com.learning.gcs.gateway.service.TaskService;
import com.learning.gcs.gateway.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/task")
@ControllerAdvice
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping("/get")
     Task get(@RequestParam(value = "asoId",defaultValue = "-1") String deviceId){
        Task task = null;
        try {
            task = taskService.get(deviceId);
        } catch (IOException e) {
            logger.error("获取Task任务失败:{}",e.getMessage());
            task.setConfig(new TaskConfig(false));
        }

        return task;
     }

    @RequestMapping("/record")
    Result record(@RequestParam(value = "asoId") String deviceId,@RequestParam String imei,@RequestParam int taskId){

        if(taskService.isAddUser(taskId,imei)){
            taskService.saveGcsTaskRecord(deviceId, imei, taskId,1);
        }

        return Constant.RESULT_SUCCESS;
    }

}
