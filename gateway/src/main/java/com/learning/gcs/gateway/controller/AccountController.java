package com.learning.gcs.gateway.controller;

import com.learning.gcs.common.entity.PhoneCaptcha;
import com.learning.gcs.gateway.bean.PhoneCaptchaBean;
import com.learning.gcs.gateway.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 18:48
 * @description
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private PhoneNumberService phoneNumberService;

    @RequestMapping("/getPhoneNumber")
    PhoneCaptchaBean getPhoneNumberByTaskId(@RequestParam("taskId") Integer taskId){

        PhoneCaptcha phoneCaptcha = phoneNumberService.findTopByTaskId(taskId);

        if(ObjectUtils.isEmpty(phoneCaptcha)){
            return new PhoneCaptchaBean();
        }else{
            PhoneCaptchaBean phoneCaptchaBean = new PhoneCaptchaBean();
            phoneCaptchaBean.setPhoneNumber(phoneCaptcha.getPhoneNumber());
            phoneCaptchaBean.setRet(1);
            return phoneCaptchaBean;
        }
    }
    @RequestMapping("/getCaptcha")
    PhoneCaptchaBean  getPhoneCaptchaByTaskId(@RequestParam("phoneNumber") String phoneNumber,
                                              @RequestParam("captchaLength") Integer captchaLength,
                                              @RequestParam("keyword") String keyword){
        PhoneCaptcha phoneCaptcha = phoneNumberService.findByPhoneNumberAndKeyword(phoneNumber,captchaLength,keyword);

        if(ObjectUtils.isEmpty(phoneCaptcha)){
            return new PhoneCaptchaBean();
        }else {
            PhoneCaptchaBean phoneCaptchaBean = new PhoneCaptchaBean();
            phoneCaptchaBean.setCaptcha(phoneCaptcha.getCaptcha());
            phoneCaptchaBean.setRet(1);
            return phoneCaptchaBean;
        }
    }
}
