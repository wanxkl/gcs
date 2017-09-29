package com.learning.gcs.gateway.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.GcsTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcsTaskServiceTest {

    private static Logger logger = LoggerFactory.getLogger(GcsTaskServiceTest.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GcsTaskService gcsTaskService;

    @Test
    public void save() throws Exception {

        GcsTask gcsTask = new GcsTask();

        gcsTask.setAppName("广电通");
        gcsTask.setApkUrl("http://cdn.vvbid.com/angel/GDTAD.apk");
        gcsTask.setRunNumber(60);
        gcsTask.setTaskCount(1000);
        gcsTask.setTaskMode("cpa");
        gcsTask.setTaskModeCode(1);
        gcsTask.setWeight(1);
        gcsTask.setTaskStatus(1);
        gcsTask.setPackageName("com.jack.jun1");
        gcsTask.setNewAddRemainCurveId(1);
        gcsTask.setNichijouRemainCurveId(1);
        gcsTask.setRemainCurveId(2);
        gcsTask.setMachineIds(null);
        gcsTaskService.save(gcsTask);
    }


    @Test
    public void getByTaskId() throws Exception {

        GcsTask gcsTask = gcsTaskService.getByTaskId(1);

        String  json = objectMapper.writeValueAsString(gcsTask);

        logger.debug("结果是：\n\t {}",json);
    }


}