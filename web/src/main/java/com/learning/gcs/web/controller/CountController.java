package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTaskLog;
import com.learning.gcs.web.service.CountChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        Page page= countChartService.findTask(15,pageNo);
        List<GcsTaskLog> list = page.getContent();
        Iterator it = list.iterator();
        int pageCount =page.getTotalPages();
        List<Integer> pageList = countChartService.pages(pageNo,pageCount);
        model.addAttribute("gcsLogList",list);
        model.addAttribute("pages",pageList);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageNo",pageNo);
        return "count_table";
    }
}
