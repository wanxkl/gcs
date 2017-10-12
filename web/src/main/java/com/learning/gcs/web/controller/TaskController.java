package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private GcsTaskService gcsTaskService;

    @RequestMapping(value = "/updateGcsTask")
    public String updateGcsTask(Model model,@RequestParam("id")int id,
                              @RequestParam(value = "apk_url")String apk_url,
                              @RequestParam("app_name") String app_name,
                              @RequestParam("find_set") String find_set,
                              @RequestParam("market_pack_name") String market_pack_name,
                              @RequestParam("market_url") String market_url,
                              @RequestParam("package_name") String package_name,
                              @RequestParam("search_txt") String search_txt,
                              @RequestParam("run_number") int run_number,
                              @RequestParam(value = "task_mode")String task_mode,
                              @RequestParam("task_mode_code") int task_mode_code,
                              @RequestParam("task_status") int task_status,
                              @RequestParam("weight") int weight,
                              @RequestParam("remain_curve_id") int remain_curve_id,
                              @RequestParam("newAddCurveId") int newAddCurveId,
                              @RequestParam("nichijou_remain_curve_id") int nichijou_remain_curve_id,
                              @RequestParam("task_count") int task_count,
                              @RequestParam("machine_ids") String machine_ids){
        gcsTaskService.updateGcsTaskById(id,app_name,apk_url,run_number,weight,task_mode_code,task_mode,package_name,market_url,market_pack_name,search_txt,find_set,task_status,task_count,machine_ids,newAddCurveId,nichijou_remain_curve_id,remain_curve_id);
        List list = gcsTaskService.finAll();
        model.addAttribute("gcsList",list);
        return "table";
    }
    @RequestMapping(value = "/deleteTask")
    public String deleteTask(Model model,@RequestParam(value = "id") int id){
        gcsTaskService.deleteById(id);
        List list = gcsTaskService.finAll();
        model.addAttribute("gcsList",list);
        return "table";
    }
    @RequestMapping(value = "/saveTask")
    public String save1(Model model,GcsTask gcsTask){
        gcsTaskService.add(gcsTask);
        List list = gcsTaskService.finAll();
        model.addAttribute("gcsList",list);
        return "table";
    }
    @RequestMapping(value="/findTasks")
    public String findTasks(Model model){
        List list = gcsTaskService.finAll();
        model.addAttribute("gcsList",list);
        return "table";
    }
}
