package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTaskRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GcsTaskRecordServiceTest {
    @Autowired
    GcsTaskRecordService gcsTaskRecordService;

    @Test
    public void save() throws Exception {

        GcsTaskRecord gcsTaskRecord = null;

        String cur = System.currentTimeMillis()+"";

        for (int i = 0; i < 1000; i++) {
             gcsTaskRecord = new GcsTaskRecord();
             gcsTaskRecord.setTaskId(1);
             gcsTaskRecord.setCreateDate("2017-09-26");
             gcsTaskRecord.setLogStatus(0);
             gcsTaskRecord.setImei(cur+i);
             gcsTaskRecord.setDailyActiveTimes(0);

             gcsTaskRecordService.save(gcsTaskRecord);
        }

    }

}