package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.web.Service.GcsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class TaskRestController {
    @Autowired
    private GcsTaskService gcsTaskService;
    @RequestMapping(value="/findTasks")
    public List<GcsTask> findTasks(@RequestParam("order")String order,
                                   @RequestParam("limit")int limit,
                                   @RequestParam("offset")int offset){
        System.out.println(limit);
        List list = gcsTaskService.finAll();
        Iterator it = list.iterator();
        while (it.hasNext()){
            GcsTask gcsTask = (GcsTask) it.next();
            System.out.println(gcsTask.getAppName());
        }
        return list;
    }
    @RequestMapping(value = "/updateGcsTask")
    public void updateGcsTask(@RequestParam("id")int id,
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
        //gcsTaskService.updateGcsTaskById(id,app_name,apk_url,run_number,weight,task_mode_code,task_mode,package_name,market_url,market_pack_name,search_txt,find_set,task_status,task_count,machine_ids,newAddCurveId,nichijou_remain_curve_id,remain_curve_id);

    }
    @RequestMapping(value = "/deleteTask")
    public void deleteTask(@RequestParam(value = "ints") int[] ints){
        gcsTaskService.deleteById(ints);
    }
    @RequestMapping(value = "/saveTask")
    public void save(@RequestParam(value = "apk_url")String apk_url,
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
        GcsTask gcsTask = new GcsTask();
        gcsTask.setApkUrl(apk_url);
        gcsTask.setAppName(app_name);
        gcsTask.setFindSet(find_set);
        gcsTask.setMachineIds(machine_ids);
        gcsTask.setMarketPackName(market_pack_name);
        gcsTask.setMarketUrl(market_url);
        gcsTask.setPackageName(package_name);
        gcsTask.setSearchTxt(search_txt);
        gcsTask.setRunNumber(run_number);
        gcsTask.setTaskMode(task_mode);
        gcsTask.setTaskModeCode(task_mode_code);
        gcsTask.setTaskStatus(task_status);
        gcsTask.setWeight(weight);
        gcsTask.setRemainCurveId(remain_curve_id);
        gcsTask.setNewAddRemainCurveId(newAddCurveId);
        gcsTask.setNichijouRemainCurveId(nichijou_remain_curve_id);
        gcsTask.setTaskCount(task_count);
        gcsTask.setMachineIds(machine_ids);
        gcsTaskService.add(gcsTask);
    }
}
