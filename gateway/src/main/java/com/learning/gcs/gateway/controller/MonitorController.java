package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.service.GcsTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    private static final Logger logger = LoggerFactory.getLogger(MonitorController.class);
    @Autowired
    private GcsTaskService gcsTaskService;
    @Value("${com.learning.gcs.gateway.scheduleToggle}")
    private String scheduleToggle;
    @RequestMapping("/setTaskCount/{taskId}/{taskCount}")
    Result setTaskCount(@PathVariable Integer taskId,@PathVariable Integer taskCount){

        logger.info("设置任务数量：taskId:{}->taskCount:{}",taskId,taskCount);

        Integer changedCount = gcsTaskService.updateTaskCountById(taskId,taskCount);

        logger.info("changedCount:{}",changedCount);
        return new Result(1,"success");

    }
    @RequestMapping("/check/value/{value}")
    String checkValue(@PathVariable("value") String value){
        if("scheduleToggle".equals(value)){
            return scheduleToggle;
        }else{
            return "NotFound";
        }
    }
}
