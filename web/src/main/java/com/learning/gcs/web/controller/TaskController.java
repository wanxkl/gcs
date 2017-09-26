package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    @Autowired
    private GcsTaskService gcsTaskService;
    @RequestMapping("/update")
    public String findOneTask(Model model,@RequestParam(value = "id")int id){
        GcsTask gcsTask = gcsTaskService.findById(id);
        System.out.println(gcsTask.getAppName());
        model.addAttribute("gcsTask",gcsTask);
        return "update";
    }
}
