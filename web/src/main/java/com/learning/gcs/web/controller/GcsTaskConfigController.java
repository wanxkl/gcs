package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTaskConfig;
import com.learning.gcs.web.Service.GcsTaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GcsTaskConfigController {
    @Autowired
    GcsTaskConfigService gcsTaskConfigService;
    @RequestMapping("/gcsTaskConfig")
    public String gcsTaskConfig(Model model){
        GcsTaskConfig gcsTaskConfig = gcsTaskConfigService.findNewGcsTaskConfig();
        model.addAttribute("gcsTaskConfig",gcsTaskConfig);
        return "gcsTaskConfig";
    }
    @RequestMapping("/updateGcsTaskConfig")
    public String updateGcsTaskConfig(Model model,@RequestParam("id") int id,
                              @RequestParam("luaUrl") String luaUrl,
                              @RequestParam("runTimeMax") int runTimeMax,
                              @RequestParam("version") int version,
                              @RequestParam("state")boolean state){
        gcsTaskConfigService.updateById(id,luaUrl,runTimeMax,version,state);
        GcsTaskConfig gcsTaskConfig = gcsTaskConfigService.findNewGcsTaskConfig();
        model.addAttribute("gcsTaskConfig",gcsTaskConfig);
        return "gcsTaskConfig";
    }
}
