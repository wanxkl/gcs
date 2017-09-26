package com.learning.gcs.gateway.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.RemainCurve;
import com.learning.gcs.common.entity.RemainCurveDetail;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.gateway.util.ObjectMapperUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemainCurveServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(RemainCurveServiceTest.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RemainCurveService remainCurveService;
    @Autowired
    private RemainCurveDetailService remainCurveDetailService;
    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private RedisReader redisReader;


    @Test
    public void findOne() throws Exception {
//        RemainCurve re =  remainCurveService.findOne(1);
//        List<RemainCurveDetail> details =  re.getRemainCurveDetails();
//        logger.debug("size:{}", details.size());
//        logger.debug(objectMapper.writeValueAsString(details));
//        redisWriter.set(KeyUtil.generatRemainCurveKey("1"),objectMapper.writeValueAsString(details));
//        Thread.sleep(1000);
        String ret = redisReader.get(KeyUtil.generatRemainCurveKey("1")).toString();

        List<RemainCurveDetail> d = objectMapper.readValue(ret, ObjectMapperUtil.getCollectionType(objectMapper,List.class,RemainCurveDetail.class));

        logger.debug("d:{}", d.size());
        for (RemainCurveDetail remainCurveDetail : d) {
            logger.debug("{}:{}:{}", remainCurveDetail.getId(), remainCurveDetail.getDistance(),remainCurveDetail.getPercent());
        }

    }


    @Test
    public void save() throws Exception {
        RemainCurve remainCurve = new RemainCurve();
        remainCurve.setRemainName("新增日曲线");
        remainCurve.setRemainType(0);

        RemainCurveDetail remainCurveDetail = null;


        RemainCurve remainCurve1 = remainCurveService.save(remainCurve);
        logger.debug(objectMapper.writeValueAsString(remainCurve1));


        for (int i = 0; i < 24; i++) {
            remainCurveDetail = new RemainCurveDetail();
            remainCurveDetail.setDistance(i);
            remainCurveDetail.setPercent(4.16f);
            remainCurveDetail.setRemainCurve(remainCurve1);
            RemainCurveDetail remainCurveDetail1 = remainCurveDetailService.save(remainCurveDetail);
            logger.debug(objectMapper.writeValueAsString(remainCurveDetail1));
        }

    }


}