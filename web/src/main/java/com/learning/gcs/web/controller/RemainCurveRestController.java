package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.RemainCurve;
import com.learning.gcs.web.Service.RemainCurveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemainCurveRestController {
    @Autowired
    RemainCurveService remainCurveService;
    @RequestMapping("/findRemain")
    public RemainCurve FindRemain(Model model, int id){
        return  remainCurveService.findOne(id);
    }
}
