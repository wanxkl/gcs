package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTaskConfig;
import com.learning.gcs.web.service.GcsTaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GcsTaskConfigRestController {
    @Autowired
    GcsTaskConfigService gcsTaskConfigService;
    @RequestMapping("/finGcsTaskConfig")
    public GcsTaskConfig findGcsTaskConfig(){
        return gcsTaskConfigService.findNewGcsTaskConfig();
    }

}
