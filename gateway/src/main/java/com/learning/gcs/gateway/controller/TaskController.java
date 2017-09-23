package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@ControllerAdvice
public class TaskController {

    @RequestMapping("/get")
     Task get(@RequestParam int deviceId){
        return new Task();
     }

    @RequestMapping("/log")
    Result log(@RequestParam int deviceId,@RequestParam String imei){
        return new Result();
    }

}
