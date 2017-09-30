package com.learning.gcs.gateway.controller;

import com.learning.gcs.common.entity.GcsTask;
import com.learning.gcs.common.entity.GcsTaskLog;
import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.Task;
import com.learning.gcs.gateway.bean.TaskConfig;
import com.learning.gcs.gateway.service.GcsTaskLogService;
import com.learning.gcs.gateway.service.GcsTaskService;
import com.learning.gcs.gateway.service.TaskService;
import com.learning.gcs.gateway.util.Constant;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/task")
@ControllerAdvice
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;
    @Autowired
    private GcsTaskLogService gcsTaskLogService;
    @Autowired
    private GcsTaskService gcsTaskService;

    @RequestMapping("/get")
    Task get(@RequestParam(value = "asoId", defaultValue = "-1") String deviceId) {
        Task task = null;
        try {
            task = taskService.get(deviceId);
            if(!ObjectUtils.isEmpty(task.getInfo())){
                task.getInfo().setSdkInt("19");
                task.getInfo().setDeviceRelease("4.4");
            }
        } catch (IOException e) {
            logger.error("获取Task任务失败:{}", e.getMessage());
            task.setConfig(new TaskConfig(false));
        }

        return task;
    }

    @RequestMapping("/record")
    Result record(@RequestParam(value = "asoId") String deviceId, @RequestParam String imei,
                  @RequestParam int taskId, @RequestParam("version") Integer version,
                HttpServletRequest request) {

        String ip = request.getHeader("X-real-ip");
        if(StringUtils.isEmpty(ip)){
            ip = request.getRemoteAddr();
        }
        GcsTask gcsTask = gcsTaskService.getByTaskId(taskId);
        if (gcsTask != null) {
            GcsTaskLog gcsTaskLog = new GcsTaskLog();
            gcsTaskLog.setImei(imei);
            gcsTaskLog.setLogStatus(0);
            gcsTaskLog.setRt(1);
            gcsTaskLog.setVersion(version);
            gcsTaskLog.setTaskId(taskId);
            gcsTaskLog.setDeviceId(deviceId);
            gcsTaskLog.setTaskName(gcsTask.getAppName());
            gcsTaskLog.setDailyActiveTimes(0);
            gcsTaskLog.setIp(ip);
            gcsTaskLogService.save(gcsTaskLog);
            gcsTaskService.save(gcsTask);

            if (taskService.isAddUser(taskId, imei)) {
                taskService.saveGcsTaskRecord(deviceId, imei, taskId, 1);
            }
        }else{
            return Constant.RESULT_FAIL;
        }
        return Constant.RESULT_SUCCESS;
    }

}
