package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.BlackList;
import com.learning.gcs.web.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gyao
 */
@Controller
public class BlackListController {
    @Autowired
    BlackListService blackListService;
    @RequestMapping("/blackList")
    public String blackList(Model model){
        model.addAttribute("blackList",blackListService.findAll());
        return "blackList";
    }
    @RequestMapping("/saveBlackList")
    public String save(Model model,@RequestParam("blackName") String blackName){
        blackListService.save(blackName);
        model.addAttribute("blackList",blackListService.findAll());
        return "blackList";
    }
    @RequestMapping("/updateBlack")
    public String update(Model model,@RequestParam("id") int id,@RequestParam("blackName") String blackName){
        blackListService.updateById(id,blackName);
        model.addAttribute("blackList",blackListService.findAll());
        return "blackList";
    }
    @RequestMapping("/deleteBlack")
    public String delete(Model model,@RequestParam("id") int id){
        blackListService.delete(id);
        model.addAttribute("blackList",blackListService.findAll());
        return "blackList";
    }

}
