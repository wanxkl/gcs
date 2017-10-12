package com.learning.gcs.gateway.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.GcsTaskPhoneCaptcha;
import com.learning.gcs.common.entity.PhoneCaptcha;
import com.learning.gcs.common.repository.GcsTaskPhoneCaptchaRepository;
import com.learning.gcs.common.repository.PhoneCaptchaRepository;
import com.learning.gcs.common.util.HttpUtil;
import com.learning.gcs.gateway.bean.CaptchaBean;
import com.learning.gcs.gateway.service.PhoneNumberService;
import com.learning.gcs.gateway.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 16:51
 * @description
 */
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberServiceImpl.class);
    private static final String CONTENT_CHAR = "optype";
    private static final String CONTENT_CAPTCHA_CHAR = "SmsCode";

    @Autowired
    private PhoneCaptchaRepository phoneCaptchaRepository;
    @Autowired
    private GcsTaskPhoneCaptchaRepository gcsTaskPhoneCaptchaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean isExist(String phoneNumber) {
        return phoneCaptchaRepository.countByPhoneNumber(phoneNumber)>0?true:false;
    }

    @Override
    public PhoneCaptcha save(PhoneCaptcha phoneCaptcha) {
        return phoneCaptchaRepository.save(phoneCaptcha);
    }

    @Override
    public PhoneCaptcha findTopByTaskId(Integer taskId) {

        List<PhoneCaptcha> list = phoneCaptchaRepository.findByTaskId(taskId);
        PhoneCaptcha phoneCaptcha = list.get(0);
        GcsTaskPhoneCaptcha gcsTaskPhoneCaptcha = new GcsTaskPhoneCaptcha();
        gcsTaskPhoneCaptcha.setGcsTaskId(taskId);
        gcsTaskPhoneCaptcha.setPhoneCaptchaId(phoneCaptcha.getId());
        gcsTaskPhoneCaptchaRepository.save(gcsTaskPhoneCaptcha);
        return phoneCaptcha;
    }

    @Override
    public PhoneCaptcha findByPhoneNumber(String phoneNumber) {

        PhoneCaptcha phoneCaptcha = phoneCaptchaRepository.findByPhoneNumber(phoneNumber);
        if(!ObjectUtils.isEmpty(phoneCaptcha)&&!StringUtils.isEmpty(phoneCaptcha.getCaptcha())){
            return phoneCaptcha;
        }
        return null;
    }

    @Override
    public Integer synPhoneNumber() {
        String ret = HttpUtil.sendGet(Constant.HOST_SYN_PHONE_NUMBER,Constant.CHARSET);
        logger.info("url:{}",Constant.HOST_SYN_PHONE_NUMBER);
        logger.info("ret:{}",ret);
        List<PhoneCaptcha> list;
        int count = 0;
        if(StringUtils.hasText(CONTENT_CHAR)){
            try {
                list = objectMapper.readValue(ret,new TypeReference<List<PhoneCaptcha>>(){});
                for (PhoneCaptcha phoneCaptcha : list) {
                    if(phoneCaptchaRepository.countByPhoneNumber(phoneCaptcha.getPhoneNumber())==0){
                        phoneCaptchaRepository.save(phoneCaptcha);
                        count ++;
                    }else{
                        //logger.info("手机号：{} 已存在");
                    }
                }
                logger.info("list.size:{}",list.size());
            } catch (IOException e) {
                logger.error("List<PhoneCaptcha>转化异常:{},ret:{}",e,ret);
            }
        }
        return count;
    }

    @Override
    public Integer SynPhoneNumberCaptcha() {
        return null;
    }

    @Override
    public PhoneCaptcha findByPhoneNumberAndKeyword(String phoneNumber,Integer captchaLength, String keyword) {
        PhoneCaptcha phoneCaptcha =  phoneCaptchaRepository.findByPhoneNumber(phoneNumber);
        String url = Constant.HOST_SYN_PHONE_CAPTCHA + "?imei="+phoneCaptcha.getImsi()+"&codeDecimal="+captchaLength+"&keyWord="+keyword;

        String ret =  HttpUtil.sendGet(url,Constant.CHARSET);
        logger.info("url:{}",url);
        logger.info("ret:{}",ret);
        if(!StringUtils.isEmpty(ret)&&ret.contains(CONTENT_CAPTCHA_CHAR)){
            try {
                List<CaptchaBean> captchaBean = objectMapper.readValue(ret,new TypeReference<List<CaptchaBean>>(){});
                if(!ObjectUtils.isEmpty(captchaBean)&&captchaBean.size()>0){
                    phoneCaptcha.setCaptcha(captchaBean.get(0).getSmsCode());
                    return phoneCaptcha;
                }
            } catch (IOException e) {
                logger.error("CaptchaBean转化异常:{},ret:{}",e,ret);
                return null;
            }
        }
        return null;
    }
}
