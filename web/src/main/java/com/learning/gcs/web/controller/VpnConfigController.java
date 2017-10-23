package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.VpnConfig;
import com.learning.gcs.web.service.VpnConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VpnConfigController {
    @Autowired
    VpnConfigService vpnConfigService;
    @RequestMapping("/vpnConfig")
    public String findAll(Model model){
        model.addAttribute("vpnConfig",vpnConfigService.findAll().get(0));
        return "vpnConfig";
    }
    @RequestMapping("/updateVpn")
    public String updateVpn(Model model, @RequestParam("id") int id, @RequestParam("time") int time){
        vpnConfigService.updateTime(id, time);
        model.addAttribute("vpnConfig",vpnConfigService.findAll().get(0));
        return "vpnConfig";
    }
}
