package com.learning.gcs.web.controller;

import com.learning.gcs.web.service.CountChartService;
import com.learning.gcs.web.service.MachineGroupService;
import com.learning.gcs.web.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MachineController {
    @Autowired
    MachineService machineService;
    @Autowired
    CountChartService countChartService;
    @Autowired
    MachineGroupService machineGroupService;
    @RequestMapping("/machines")
    public String Machines(Model model,@RequestParam("pageNo") int pageNo){
        int pageSize = 15;
        Page page = machineService.findByPage(pageSize,pageNo);
        model.addAttribute("machines",page.getContent());
        model.addAttribute("pages",countChartService.pages(pageNo,page.getTotalPages()));
        model.addAttribute("pageCount",page.getTotalPages());
        model.addAttribute("pageNo",pageNo);
        return "machines";
    }
    @RequestMapping("/addMachine")
    public String saveMachine(Model model,
                              @RequestParam("machineName") String machineName,
                              @RequestParam("machineState") int machineState,
                              @RequestParam("pageNo")int pageNo){
        machineService.addMachine(machineName,machineState);
        int pageSize = 15;
        Page page = machineService.findByPage(pageSize,pageNo);
        model.addAttribute("groups",machineGroupService.findAll());
        model.addAttribute("machines",page.getContent());
        model.addAttribute("pages",countChartService.pages(pageNo,page.getTotalPages()));
        model.addAttribute("pageCount",page.getTotalPages());
        model.addAttribute("pageNo",pageNo);
        return "machines";
    }
    @RequestMapping("deleteMachine")
    public String deleteMachine(Model model,@RequestParam("id") int id,@RequestParam("pageNo") int pageNo){
        machineService.deleteMachine(id);
        int pageSize = 15;
        Page page = machineService.findByPage(pageSize,pageNo);
        model.addAttribute("groups",machineGroupService.findAll());
        model.addAttribute("machines",page.getContent());
        model.addAttribute("pages",countChartService.pages(pageNo,page.getTotalPages()));
        model.addAttribute("pageCount",page.getTotalPages());
        model.addAttribute("pageNo",pageNo);
        return "machines";
    }
}
