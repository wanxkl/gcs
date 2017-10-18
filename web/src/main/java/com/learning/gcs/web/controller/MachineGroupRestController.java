package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.MachineGroup;
import com.learning.gcs.web.service.MachineGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gyao
 */
@RestController
public class MachineGroupRestController {
    @Autowired
    MachineGroupService machineGroupService;
    @RequestMapping("/findGroups")
    public List<MachineGroup> findMachineGroup(){
        return machineGroupService.findAll();
    }
}
