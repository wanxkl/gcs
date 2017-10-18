package com.learning.gcs.web.controller;

import com.learning.gcs.web.service.RemainCurveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RemainCurveController {
    @Autowired
    RemainCurveService remainCurveService;
    @RequestMapping("/remain_setting")
    public String RemainSetting(Model model){
        model.addAttribute("details",remainCurveService.getRemainDetail());
        return "remain_setting";
    }
    @RequestMapping("/saveRemainDetail")
    public String saveRemainDetail(Model model, @RequestParam("remainName")String remainName,
                                   @RequestParam("remainType")String remainType,
                                   @RequestParam("curveData")String curveData){
        String [] curveDatas = curveData.split(",");
        remainCurveService.saveRemainDetail(curveDatas,remainName,Integer.parseInt(remainType));
        model.addAttribute("details",remainCurveService.getRemainDetail());
        return "remain_setting";
    }
    @RequestMapping("/deleteRemain")
    public String DeleteRemain(Model model,@RequestParam("id")String id){
        remainCurveService.deleteRemain(Integer.parseInt(id));
        model.addAttribute("details",remainCurveService.getRemainDetail());
        return "remain_setting";
    }
    @RequestMapping("/updateRemainDetail")
    public String updateRemainDetail(Model model, HttpServletRequest request,
                                     @RequestParam("id") int id,
                                     @RequestParam("remainType") int remainType,@RequestParam("remainName")String remainName){
        String []pencents=request.getParameterValues("percent");
        System.out.println("id="+id);
        remainCurveService.updateRemainDetail(remainName,remainType,id,pencents);
        model.addAttribute("details",remainCurveService.getRemainDetail());
        return "remain_setting";
    }
}
