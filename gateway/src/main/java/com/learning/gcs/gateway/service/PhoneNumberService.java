package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.PhoneCaptcha;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 16:45
 * @description
 */
public interface PhoneNumberService {

    boolean isExist(String phoneNumber);

    PhoneCaptcha save(PhoneCaptcha phoneCaptcha);

    PhoneCaptcha findTopByTaskId(Integer taskId);

    PhoneCaptcha findByPhoneNumber(String phoneNumber);

    Integer synPhoneNumber();

    Integer SynPhoneNumberCaptcha();

    PhoneCaptcha findByPhoneNumberAndKeyword(String phoneNumber,Integer captchaLength, String keyword);
}
