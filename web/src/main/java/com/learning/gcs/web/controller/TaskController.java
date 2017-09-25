package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private GcsTaskService gcsTaskService;
    @RequestMapping(value="/findTasks")
    public List<GcsTask> findTasks(){
        return gcsTaskService.finAll();
    }
    @RequestMapping("/findOneTask")
    public GcsTask findOneTask(@RequestParam(value = "id")int id){
        return gcsTaskService.findById(id);
    }
    public void updateGcsTask(@RequestParam(value = "id") int id){

    }
    @RequestMapping("/deleteTask")
    public void deleteTask(@RequestParam(value = "ints") int[] ints){
        gcsTaskService.deleteById(ints);
    }
}
