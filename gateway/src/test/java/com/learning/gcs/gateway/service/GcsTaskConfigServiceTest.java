package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.GcsTaskConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcsTaskConfigServiceTest {

    private GcsTaskConfigService gcsTaskConfigService;

    @Test
    public void getGcsTaskConfig() throws Exception {
    }

    @Test
    public void save() throws Exception {

        GcsTaskConfig config = new GcsTaskConfig();
        config.setLuaUrl("http://192.168.1.107:8080/aso/luaDate.zip");
        config.setRunTimeMax(60);
        config.setState(true);
        config.setVersion(201709131);


    }

}