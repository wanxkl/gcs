package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.web.Service.GcsTaskConfigService;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GcsTaskRestController {
    @Autowired
    GcsTaskService gcsTaskService;
    @RequestMapping("/findOneTask")
    public GcsTask findOneTask(Model model, @RequestParam(value = "id")int id){
        GcsTask gcsTask = gcsTaskService.findById(id);
        return gcsTask;
    }
}
