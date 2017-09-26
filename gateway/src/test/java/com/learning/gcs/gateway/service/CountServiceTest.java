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
public class CountServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(CountServiceTest.class);

    @Autowired
    private CountService countService;

    @Test
    public void getAndSetTaskCount() throws Exception {

        int num = 10;

        for (int i = 0; i < num; i++) {
            int count = countService.getTaskCount(1,12);
            logger.debug("count:{}",count);
        }



    }



}