package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private GcsTaskService gcsTaskService;
    @RequestMapping(value="/findTasks")
    public List<GcsTask> findTasks(){
        return gcsTaskService.finAll();
    }
    @RequestMapping("/findOneTask")
    public GcsTask findOneTask(@RequestParam(value = "id")int id){
        return gcsTaskService.findById(id);
    }
    public void updateGcsTask(@RequestParam(value = "id") int id){

    }
    @RequestMapping("/deleteTask")
    public void deleteTask(@RequestParam(value = "ints") int[] ints){
        gcsTaskService.deleteById(ints);
    }
    public void save(@RequestParam(value = "apk_url")String apk_url,
                     @RequestParam("app_name") String app_name,
                     @RequestParam("find_set") String find_set,
                     @RequestParam("market_pack_name") String market_pack_name,
                     @RequestParam("market_url") String market_url,
                     @RequestParam("package_name") String package_name,
                     @RequestParam("search_txt") String search_txt,
                     @RequestParam("run_number") String run_number,
                     @RequestParam(value = "task_mode")String task_mode,
                     @RequestParam("task_mode_code") int task_mode_code,
                     @RequestParam("task_status") int task_status,
                     @RequestParam("weight") int weight,
                     @RequestParam("remain_curve_id") int remain_curve_id,
                     @RequestParam("new_add_remain_curve_id") int new_add_remain_curve_id,
                     @RequestParam("nichijou_remain_curve_id") int nichijou_remain_curve_id,
                     @RequestParam("task_count") int task_count,
                     @RequestParam("machine_ids") String machine_ids){
        GcsTask gcsTask = new GcsTask();
        gcsTask.setApkUrl(apk_url);
        gcsTask.setAppName(app_name);
        gcsTask.setFindSet(find_set);
        gcsTask.setMachineIds(machine_ids);
        gcsTask.setMarketPackName(market_pack_name);
        gcsTask.setMarketUrl(market_url);
        gcsTask.setPackageName(package_name);
        gcsTask.setSearchTxt(search_txt);
//        gcsTask.setRunNumber(run_number);
        gcsTaskService.add(gcsTask);
    }
}
