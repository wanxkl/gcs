package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.BlackList;
import com.learning.gcs.web.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlackListRestController {
    @Autowired
    BlackListService blackListService;
    @RequestMapping("/findOneBlack")
    public BlackList findOne(@RequestParam("id") int id){
        return blackListService.findOne(id);
    }
}
