package com.learning.gcs.gateway.bean;

import java.io.Serializable;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 18:50
 * @description
 */
public class PhoneCaptchaBean implements Serializable{

    private Integer ret  = 0;

    private String phoneNumber;

    private String captcha;

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
