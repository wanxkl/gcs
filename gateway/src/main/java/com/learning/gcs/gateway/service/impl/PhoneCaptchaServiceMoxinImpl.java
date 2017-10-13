package com.learning.gcs.gateway.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.GcsTaskPhoneCaptcha;
import com.learning.gcs.common.entity.PhoneCaptcha;
import com.learning.gcs.common.repository.GcsTaskPhoneCaptchaRepository;
import com.learning.gcs.common.repository.PhoneCaptchaRepository;
import com.learning.gcs.common.util.HttpUtil;
import com.learning.gcs.gateway.bean.CaptchaBean;
import com.learning.gcs.gateway.bean.PhoneCaptchaBean;
import com.learning.gcs.gateway.service.PhoneCaptchaService;
import com.learning.gcs.gateway.util.CaptchaUtil;
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
 * @created 2017/10/13 11:34
 * @description
 */
@Service
public class PhoneCaptchaServiceMoxinImpl implements PhoneCaptchaService{

    private static final Logger logger = LoggerFactory.getLogger(PhoneCaptchaServiceMoxinImpl.class);
    private static final String CONTENT_CAPTCHA_CHAR = "SmsCode";

    @Autowired
    private PhoneCaptchaRepository phoneCaptchaRepository;
    @Autowired
    private GcsTaskPhoneCaptchaRepository gcsTaskPhoneCaptchaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public PhoneCaptchaBean getPhoneNumber(Integer taskId) {
        List<PhoneCaptcha> list = phoneCaptchaRepository.findByTaskId(taskId);
        if(!ObjectUtils.isEmpty(list)&&list.size()>0){
            PhoneCaptcha phoneCaptcha = list.get(0);
            GcsTaskPhoneCaptcha gcsTaskPhoneCaptcha = new GcsTaskPhoneCaptcha();
            gcsTaskPhoneCaptcha.setGcsTaskId(taskId);
            gcsTaskPhoneCaptcha.setPhoneCaptchaId(phoneCaptcha.getId());
            gcsTaskPhoneCaptchaRepository.save(gcsTaskPhoneCaptcha);
            return new PhoneCaptchaBean().buildPhoneNumber(phoneCaptcha.getPhoneNumber());
        }
        return new PhoneCaptchaBean();
    }

    @Override
    public PhoneCaptchaBean getPhoneCaptcha(Integer taskId, String phoneNumber) {
        PhoneCaptcha phoneCaptcha =  phoneCaptchaRepository.findByPhoneNumber(phoneNumber);
//        String url = Constant.HOST_SYN_PHONE_CAPTCHA + "?imsi="+phoneCaptcha.getImsi()+"&codeDecimal="+""+"&keyWord=";
        String url = Constant.HOST_SYN_PHONE_CAPTCHA + "?imsi="+phoneCaptcha.getImsi();

        String ret =  HttpUtil.sendGet(url, Constant.CHARSET);
        logger.info("url:{}",url);
        logger.info("ret:{}",ret);
        if(!StringUtils.isEmpty(ret)&&ret.contains(CONTENT_CAPTCHA_CHAR)){
            try {
                List<CaptchaBean> captchaBean = objectMapper.readValue(ret, new TypeReference<List<CaptchaBean>>(){});
                if(!ObjectUtils.isEmpty(captchaBean)&&captchaBean.size()>0){
                    CaptchaBean temp = null;
                    for (CaptchaBean bean : captchaBean) {
                        if(ObjectUtils.isEmpty(temp)) {
                            temp = bean;
                        }else {
                            if(temp.getInputDate().compareTo(bean.getInputDate())<0) {
                                temp = bean;
                            }
                        }
                    }
                    String captchaContent = temp.getSmsContent();
                    String captcha = CaptchaUtil.getCaptcha(captchaContent, 6);
                    if (StringUtils.isEmpty(captcha)) {
                        captcha = CaptchaUtil.getCaptcha(captchaContent, 4);
                    }
                    PhoneCaptchaBean phoneCaptchaBean = new PhoneCaptchaBean().buildCaptcha(captcha);

                    return phoneCaptchaBean;
                }
            } catch (IOException e) {
                logger.error("CaptchaBean转化异常:{},ret:{}",e,ret);
                return new PhoneCaptchaBean();
            }
        }
        return new PhoneCaptchaBean();
    }

}
