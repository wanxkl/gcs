package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class TaskRestController {
    @Autowired
    private GcsTaskService gcsTaskService;


}
