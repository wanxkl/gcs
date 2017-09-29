package com.learning.gcs.web.controller;

import com.learning.gcs.web.Service.CountChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class CountRestController {
    @Autowired
    private CountChartService countChartService;
    @RequestMapping("/countDayChart")
    public List<Integer> charAdd(@RequestParam("taskName")String taskName,@RequestParam("timeIn")String timeIn){
        //System.out.println(taskName);
        List<Integer> ints =countChartService.findIncreasUsers(taskName,timeIn) ;
        return ints;
    }
    @RequestMapping("/countRemain")
    public List charRemain(@RequestParam("taskName")String taskName,@RequestParam("timeIn")String timeIn){
        List counts = countChartService.findRemainUsers(taskName,timeIn);
        return counts;
    }
}