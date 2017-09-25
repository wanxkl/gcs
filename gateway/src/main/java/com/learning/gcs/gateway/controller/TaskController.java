package com.learning.gcs.gateway.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import com.learning.gcs.gateway.service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@ControllerAdvice
public class TaskController {
    @Autowired
    GcsTaskService gcsTaskService;
    @RequestMapping("/get")
     Task get(@RequestParam int deviceId){
        return new Task();
     }
    @RequestMapping("/log")
    Result log(@RequestParam int deviceId,@RequestParam String imei){
        return new Result();
    }
    //查看所有任务
    @RequestMapping(value = "/findTasks",method = RequestMethod.GET)
    List<GcsTask> findTasks(){
        return  gcsTaskService.findAll();
    }
}
