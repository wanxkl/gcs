package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.Machine;
import com.learning.gcs.web.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gyao
 */
@RestController
public class MachineRestController {
    @Autowired
    MachineService machineService;
    @RequestMapping("/findMachines")
    public List<Machine> findMachines(){
        return machineService.findAll();
    }
}
