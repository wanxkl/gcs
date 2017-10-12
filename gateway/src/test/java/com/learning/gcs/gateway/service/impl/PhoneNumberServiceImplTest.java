package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.PhoneCaptcha;
import com.learning.gcs.gateway.service.PhoneNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 18:01
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberServiceImplTest.class);
    @Autowired
    private PhoneNumberService phoneNumberService;

    @Test
    public void synPhoneNumber() throws Exception {
        phoneNumberService.synPhoneNumber();
    }

    @Test
    public void findTopByTaskId() throws Exception {
        for (int i = 0; i < 10; i++) {
            PhoneCaptcha phoneCaptcha = phoneNumberService.findTopByTaskId(1);
            logger.info("结果：{}",phoneCaptcha.getPhoneNumber());
        }
    }

    @Test
    public void findByPhoneNumber() throws Exception {
        PhoneCaptcha phoneCaptcha = phoneNumberService.findByPhoneNumber("13156692918");
        logger.info("结果：{}",phoneCaptcha);
        if(!ObjectUtils.isEmpty(phoneCaptcha)){
            logger.info("验证码:{}",phoneCaptcha.getCaptcha());
        }
    }
}