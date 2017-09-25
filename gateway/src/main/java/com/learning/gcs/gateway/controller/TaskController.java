package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import com.learning.gcs.gateway.service.TaskService;
import com.learning.gcs.gateway.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@ControllerAdvice
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/get")
     Task get(@RequestParam(value = "asoId",defaultValue = "-1") String deviceId){
        return taskService.get(deviceId);
     }

    @RequestMapping("/record")
    Result record(@RequestParam(value = "asoId") String deviceId,@RequestParam String imei,@RequestParam int taskId,@RequestParam(defaultValue = "0") int rt){

        return taskService.saveGcsTaskRecord(deviceId, imei, taskId,rt);
    }

}
