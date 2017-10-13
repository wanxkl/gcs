package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.PhoneCaptchaBean;
import com.learning.gcs.gateway.service.PhoneCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
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

    private static String captcha = null;
    private static String phone = null;
    private static String testAsoId = null;



    @Autowired
    public PhoneCaptchaController(ApplicationContext applicationContext) {
        this.phoneCaptchaService = (PhoneCaptchaService)applicationContext.getBean("phoneCaptchaServiceImpl");
    }

    @RequestMapping("/getPhoneNumber")
    PhoneCaptchaBean getPhoneNumber(@RequestParam Integer taskId ,@RequestParam(required = false) String asoId){

        if(!StringUtils.isEmpty(testAsoId)&&testAsoId.equals(asoId)){
            if(StringUtils.isEmpty(phone)){
                return  new PhoneCaptchaBean().buildPhoneNumber("15504602892");
            }
            return  new PhoneCaptchaBean().buildPhoneNumber(phone);
        }

        return phoneCaptchaService.getPhoneNumber(taskId);
    }

    @RequestMapping("/getPhoneCaptcha")
    PhoneCaptchaBean getPhoneCaptcha(@RequestParam Integer taskId,@RequestParam String phoneNumber,@RequestParam(required = false) String asoId){
        if(!StringUtils.isEmpty(testAsoId)&&testAsoId.equals(asoId)) {
            if(StringUtils.isEmpty(captcha)){
                return new PhoneCaptchaBean();
            }else {
                return new PhoneCaptchaBean().buildCaptcha(captcha);
            }

        }
            return phoneCaptchaService.getPhoneCaptcha(taskId,phoneNumber);


    }

    //**************************************//
    //以下测试

    @RequestMapping("/setPhoneCaptcha")
    String setCaptcha(@RequestParam String PhoneCaptcha){
        captcha = PhoneCaptcha;
        return captcha;
    }

    @RequestMapping("/setPhoneNumber")
    String setPhone(@RequestParam String phoneNumber){
        phone = phoneNumber;
        return phone;
    }

    @RequestMapping("/setAsoId")
    String setAsoId(@RequestParam String asoId){
        testAsoId = asoId;
        return testAsoId;
    }
}
