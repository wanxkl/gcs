package com.learning.gcs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountController {
    @RequestMapping("/chart_user_add")
    public String charAdd(){
        return "chart_user_add";
    }

}
