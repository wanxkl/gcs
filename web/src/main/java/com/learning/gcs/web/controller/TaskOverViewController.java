package com.learning.gcs.web.controller;

import com.learning.gcs.web.service.CountChartService;
import com.learning.gcs.web.service.GcsTaskOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Gyao
 */
@Controller
public class TaskOverViewController {
    @Autowired
    GcsTaskOverviewService gcsTaskOverViewService;
    @Autowired
    CountChartService countChartService;
    /*@RequestMapping("/findAllTaskOverView")

    public String findAll(Model model,@RequestParam("pageNo") int pageNo){
        int pageSize = 15;
        Page viewsPage = gcsTaskOverViewService.findByPage(pageNo,);
        model.addAttribute("taskOverViews",viewsPage.getContent());
        int pageCount =viewsPage.getTotalPages();
        List<Integer> pageList = countChartService.pages(pageNo,pageCount);
        model.addAttribute("pages",pageList);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageNo",pageNo);
        return "taskOverView";
    }*/

}
