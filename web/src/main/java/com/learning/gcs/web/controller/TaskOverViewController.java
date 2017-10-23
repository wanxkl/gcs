package com.learning.gcs.web.controller;

import com.learning.gcs.web.service.CountChartService;
import com.learning.gcs.web.service.GcsTaskOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Convert;
import javax.persistence.Converter;
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
    @Autowired
    Page page;

    @RequestMapping("/findAllTaskOverView")
    public String findAll(Model model,@RequestParam("pageNo") int pageNo){

        return "taskOverView";
    }

}
