package com.learning.gcs.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class CountRestController {

    @RequestMapping("/countDayChart")
    public List<Integer> charAdd(@RequestParam("taskName")String taskName,@RequestParam("timeIn")String timeIn){
        System.out.println(taskName);
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(14);
        ints.add(54);
        ints.add(23);
        ints.add(23);
        ints.add(23);
        ints.add(11);
        ints.add(67);
        return ints;
    }
}