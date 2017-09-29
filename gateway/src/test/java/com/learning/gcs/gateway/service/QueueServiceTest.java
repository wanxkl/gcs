package com.learning.gcs.gateway.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.GcsDeviceInfo;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
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
    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private RedisReader redisReader;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getDeviceInfoByTaskId() throws Exception {
        GcsDeviceInfo gcsDeviceInfo = queueService.getDeviceInfoByTaskId(1,15);

        logger.debug("获取的结果:{}",gcsDeviceInfo);
        logger.debug("获取的结果:{}",objectMapper.writeValueAsString(gcsDeviceInfo));
    }


    @Test
    public void generateQueueByTaskIdAndHour() throws Exception {
        int queueCount = queueService.generateQueueByTaskIdAndHour(1,15);
        logger.debug("queueCount:{}",queueCount);

    }


    @Test
    public void generate24HourQueue() throws Exception {
        Integer taskId = 1;
        Integer taskCount = 0;

        for (int i = 0; i < 24; i++) {
            int ret = queueService.generateQueueByTaskIdAndHour(taskId,i);
            taskCount +=ret;
            logger.debug("第{}小时的任务数为:{}",i,ret);
        }
        logger.debug("留存任务总数为:{}",taskCount);
    }

    @Test
    public void process() throws Exception {

        Integer taskId = 1;
        Integer hour = 15;
        String key = KeyUtil.generateQueueKey(taskId,hour);

        //先清楚队列：
        //redisWriter.delete(key);

        //int queueCount = queueService.generateQueueByTaskIdAndHour(taskId,hour);
        //logger.debug("queueCount:{}",queueCount);
        Long queueSize = redisReader.getQueueSize(key);

        logger.debug("Total :{}",queueSize);

        for (int i = 0; i < queueSize; i++) {
            Object o= redisWriter.rightPop(key);
            logger.debug("获取的队列值:{}",o);
        }

        logger.debug("剩余Total:{}",redisReader.getQueueSize(key));

    }
}