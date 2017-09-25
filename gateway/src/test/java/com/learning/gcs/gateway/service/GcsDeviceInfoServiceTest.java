package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsDeviceInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcsDeviceInfoServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(GcsDeviceInfoServiceTest.class);
    @Autowired
    private GcsDeviceInfoService gcsDeviceInfoService;

    @Test
    public void getByTaskId() throws Exception {
            gcsDeviceInfoService.getByTaskId(1);

    }

    @Test
    public void save() throws Exception {

        GcsDeviceInfo gcs =  gcsDeviceInfoService.getByTaskId(1);
        gcsDeviceInfoService.save(gcs);

    }

}