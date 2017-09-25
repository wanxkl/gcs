package com.learning.gcs.gateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.gateway.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET)
    String doTest(){
        System.out.println(adminUserService);

        System.out.println(applicationContext);
        System.out.println(redisWriter);
        System.out.println(objectMapper);

        for (String s : applicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        return null;
    }

}
