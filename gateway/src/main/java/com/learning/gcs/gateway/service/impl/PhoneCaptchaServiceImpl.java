package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.GcsTaskPhoneCaptchaChannel;
import com.learning.gcs.common.entity.GcsTaskPhoneCaptchaLog;
import com.learning.gcs.common.entity.PhoneCaptchaChannel;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.GcsTaskPhoneCaptchaChannelRepository;
import com.learning.gcs.common.repository.GcsTaskPhoneCaptchaLogRepository;
import com.learning.gcs.common.repository.PhoneCaptchaChannelRepository;
import com.learning.gcs.gateway.bean.PhoneCaptchaBean;
import com.learning.gcs.gateway.service.PhoneCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.util.concurrent.TimeUnit;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/13 11:18
 * @description
 */
@Service
public class PhoneCaptchaServiceImpl implements PhoneCaptchaService {

    @Autowired
    private GcsTaskPhoneCaptchaChannelRepository gcsTaskPhoneCaptchaChannelRepository;
    @Autowired
    private PhoneCaptchaChannelRepository phoneCaptchaChannelRepository;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private RedisReader redisReader;
    @Autowired
    private GcsTaskPhoneCaptchaLogRepository gcsTaskPhoneCaptchaLogRepository;
    @Override
    public PhoneCaptchaBean getPhoneNumber(Integer taskId) {

        GcsTaskPhoneCaptchaChannel gcsTaskPhoneCaptchaChannel = gcsTaskPhoneCaptchaChannelRepository.findTopByGcsTaskIdAndStatus(taskId,1);

        PhoneCaptchaChannel phoneCaptchaChannel = phoneCaptchaChannelRepository.getOne(gcsTaskPhoneCaptchaChannel.getPhoneCaptchaChannelId());

        PhoneCaptchaService phoneCaptchaService = (PhoneCaptchaService)applicationContext.getBean(phoneCaptchaChannel.getChannelService());

        PhoneCaptchaBean phoneCaptchaBean = phoneCaptchaService.getPhoneNumber(taskId);
        if(!ObjectUtils.isEmpty(phoneCaptchaBean)&&phoneCaptchaBean.getRet()==1){
            //记录缓存
            String key = KeyUtil.generateCaptchaChannelKey(taskId,phoneCaptchaBean.getPhoneNumber());
            redisWriter.set(key, phoneCaptchaChannel.getId()+"", 2, TimeUnit.HOURS);

            //记录日志
            GcsTaskPhoneCaptchaLog gcsTaskPhoneCaptchaLog = new GcsTaskPhoneCaptchaLog();
            gcsTaskPhoneCaptchaLog.setGcsTaskId(taskId);
            gcsTaskPhoneCaptchaLog.setPhoneCaptchaChannelId(phoneCaptchaChannel.getId());
            gcsTaskPhoneCaptchaLog.setPhoneNumber(phoneCaptchaBean.getPhoneNumber());
            gcsTaskPhoneCaptchaLogRepository.save(gcsTaskPhoneCaptchaLog);

        }
        return phoneCaptchaBean;
    }

    @Override
    public PhoneCaptchaBean getPhoneCaptcha(Integer taskId, String phoneNumber) {
        String key = KeyUtil.generateCaptchaChannelKey(taskId,phoneNumber);

        Object channelId = redisReader.get(key);
        if(!StringUtils.isEmpty(channelId)){
            PhoneCaptchaChannel phoneCaptchaChannel = phoneCaptchaChannelRepository.getOne(Integer.parseInt(channelId.toString()));
            PhoneCaptchaService phoneCaptchaService = (PhoneCaptchaService)applicationContext.getBean(phoneCaptchaChannel.getChannelService());
            PhoneCaptchaBean phoneCaptchaBean =  phoneCaptchaService.getPhoneCaptcha(taskId,phoneNumber);
            if(!ObjectUtils.isEmpty(phoneCaptchaBean)&&phoneCaptchaBean.getRet()==1){
                //记录日志
                gcsTaskPhoneCaptchaLogRepository.updateCaptchaByTaskIdAndAndPhoneCaptchaChannelIdAndPhoneNumber(phoneCaptchaBean.getCaptcha(),
                                                                                                                taskId,
                                                                                                                phoneCaptchaChannel.getId(),phoneNumber);
            }else{
//                gcsTaskPhoneCaptchaLogRepository.updateCaptchaByTaskIdAndAndPhoneCaptchaChannelIdAndPhoneNumber("test",taskId,
//                                                                                                                phoneCaptchaChannel.getId(),phoneNumber);
            }

            return  phoneCaptchaBean;
        }else{
            return new PhoneCaptchaBean();
        }
    }
}
