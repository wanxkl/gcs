package com.learning.gcs.gateway.service;

import com.learning.gcs.gateway.bean.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void get() throws Exception {
        Task task = taskService.get("1");

        
    }

    @Test
    public void isAddUser() throws Exception {

        String imeiExit = "99000652201027";
        String imeiNotExit = "000";

        Integer taskId = 1;

        Assert.assertEquals(false,taskService.isAddUser(taskId,imeiExit));
        Assert.assertEquals(true,taskService.isAddUser(taskId,imeiNotExit));

    }

}