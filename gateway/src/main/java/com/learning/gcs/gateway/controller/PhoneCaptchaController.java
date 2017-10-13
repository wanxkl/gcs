package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.PhoneCaptchaBean;
import com.learning.gcs.gateway.service.PhoneCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 21:37
 * @description
 */
@RestController
@RequestMapping("/captcha")
public class PhoneCaptchaController {

    private PhoneCaptchaService phoneCaptchaService;

    @Autowired
    public PhoneCaptchaController(ApplicationContext applicationContext) {
        this.phoneCaptchaService = (PhoneCaptchaService)applicationContext.getBean("phoneCaptchaServiceImpl");
    }

    @RequestMapping("/getPhoneNumber")
    PhoneCaptchaBean getPhoneNumber(@RequestParam Integer taskId){
        return phoneCaptchaService.getPhoneNumber(taskId);
    }

    @RequestMapping("/getPhoneCaptcha")
    PhoneCaptchaBean getPhoneCaptcha(@RequestParam Integer taskId,@RequestParam String phoneNumber){
        return phoneCaptchaService.getPhoneCaptcha(taskId,phoneNumber);
    }
}
