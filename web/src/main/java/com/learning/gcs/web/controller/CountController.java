package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTaskLog;
import com.learning.gcs.web.Service.CountChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class CountController {
    @Autowired
    private CountChartService countChartService;
    @RequestMapping("/chart_user_add")
    public String charAdd(){
        return "chart_user_add";
    }
    @RequestMapping("/count_table")
    public String countTable(Model model,@RequestParam("pageNo")int pageNo){
        List<GcsTaskLog> list = countChartService.findTask(20,pageNo);
        Iterator it = list.iterator();
        int pages = countChartService.findPages(20,pageNo);
        List pageList = new ArrayList();
        for (int i=1;i<=pages;i++){
            pageList.add(i);
        }
        model.addAttribute("gcsLogList",list);
        model.addAttribute("pages",pageList);
        return "count_table";
    }
}
