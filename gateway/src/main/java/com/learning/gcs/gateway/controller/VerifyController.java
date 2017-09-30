package com.learning.gcs.gateway.controller;

import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/verify")
public class VerifyController {
    private static final Logger logger = LoggerFactory.getLogger(VerifyController.class);

    @Autowired
    private RedisTemplate stringRedisTemplate;

    @RequestMapping("/ip")
    Result ip(HttpServletRequest request, @RequestParam Integer taskId){
        String ip = request.getHeader("X-real-ip");
        if(StringUtils.isEmpty(ip)){
            ip = request.getRemoteAddr();
        }
        String key = KeyUtil.generateIpKey(taskId);

        boolean isExist =  stringRedisTemplate.opsForSet().members(key).contains(ip);
        if (isExist){
            return Constant.RESULT_FAIL;
        }else{
            stringRedisTemplate.opsForSet().add(key,ip);
            return Constant.RESULT_SUCCESS;
        }

    }

}
