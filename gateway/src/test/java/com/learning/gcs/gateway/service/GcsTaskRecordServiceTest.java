package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsDeviceInfo;
import com.learning.gcs.common.entity.GcsTaskRecord;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcsTaskRecordServiceTest {
    @Autowired
    GcsTaskRecordService gcsTaskRecordService;
    @Autowired
    private GcsDeviceInfoService gcsDeviceInfoService;

    @Test
    public void save() throws Exception {

        GcsTaskRecord gcsTaskRecord;
        List<GcsDeviceInfo> list = gcsDeviceInfoService.findAll();

        for (GcsDeviceInfo gcsDeviceInfo : list) {
            gcsTaskRecord = new GcsTaskRecord();
            gcsTaskRecord.setTaskId(1);
            gcsTaskRecord.setCreateDate("2017-09-27");
            gcsTaskRecord.setLogStatus(0);
            gcsTaskRecord.setImei(gcsDeviceInfo.getImei());
            gcsTaskRecord.setDailyActiveTimes(0);

            gcsTaskRecordService.save(gcsTaskRecord);
        }
    }

    @Test
    public void countByTaskIdAndImei() throws Exception {
        long actual = gcsTaskRecordService.countByTaskIdAndImei(1,"99000652201027");
        long expected = 1l;

        Assert.assertEquals(expected,actual);

    }
}