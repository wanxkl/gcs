package com.learning.gcs.gateway.service;

import com.learning.gcs.gateway.bean.PhoneCaptchaBean;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 20:52
 * @description
 */
public interface PhoneCaptchaService {

     PhoneCaptchaBean getPhoneNumber(Integer taskId);

     PhoneCaptchaBean getPhoneCaptcha(Integer taskId,String phoneNumber);

     PhoneCaptchaBean getPhoneNumber(Integer taskId,String phoneNumber);

     void releasePhoneNumber(Integer taskId, String phoneNumber);
}
