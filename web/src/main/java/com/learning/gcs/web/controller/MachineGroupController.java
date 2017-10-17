package com.learning.gcs.web.controller;

import com.learning.gcs.web.Service.MachineGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Gyao
 */
@Controller
public class MachineGroupController {
    @Autowired
    MachineGroupService machineGroupService;
    @RequestMapping("machinesGroup")
    public String groupHome(Model model){
        model.addAttribute("groups",machineGroupService.findAll());
        return "machineGroup";
    }
    @RequestMapping("deleteGroup")
    public String deleteGroup(Model model,@RequestParam("id") int id){
        machineGroupService.deleteGroupMachine(id);
        model.addAttribute("groups",machineGroupService.findAll());
        return "machineGroup";
    }
    @RequestMapping("/addGroup")
    public String addGroup(HttpServletRequest request,Model model, @RequestParam("groupName") String groupName){
        String [] ids = request.getParameterValues("id");
        machineGroupService.addGroup(groupName,ids);
        model.addAttribute("groups",machineGroupService.findAll());
        return "machineGroup";
    }
    @RequestMapping("/deleteMachineGroup")
    public String deleteMachineGroup(Model model,
                                     @RequestParam("groupId") int groupId,
                                     @RequestParam("machineId") int machineId){
        machineGroupService.deleteMachineGroup(groupId,machineId);
        model.addAttribute("groups",machineGroupService.findAll());
        return "machineGroup";
    }
}
