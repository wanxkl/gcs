package com.learning.gcs.gateway.service;

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
public class QueueServiceTest {

    private static  final Logger logger = LoggerFactory.getLogger(QueueServiceTest.class);

    @Autowired
    private QueueService queueService;

    @Test
    public void getDeviceInfoByTaskId() throws Exception {
        queueService.getDeviceInfoByTaskId(1);
    }


    @Test
    public void generateQueueByTaskIdAndHour() throws Exception {
        int queueCount = queueService.generateQueueByTaskIdAndHour(1,16);
        logger.debug("queueCount:",queueCount);

    }
}