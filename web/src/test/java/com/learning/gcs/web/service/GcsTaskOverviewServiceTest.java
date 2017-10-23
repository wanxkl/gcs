package com.learning.gcs.web.service;

import com.learning.gcs.common.util.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/23 14:49
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GcsTaskOverviewServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(GcsTaskOverviewServiceTest.class);

    @Autowired
    private GcsTaskOverviewService gcsTaskOverviewService;

    @Test
    public void batchUpdate() throws Exception {
        //生成26日内数据
        for (int i = 1; i < 26; i++) {
             String createDate = TimeUtil.getFormatDateDistinceNow(i);
             Integer count = gcsTaskOverviewService.batchUpdate(createDate);
             logger.info("日期：{},生成: {}",createDate,count);
        }

    }

}