package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/task")
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
