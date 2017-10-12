package com.learning.gcs.gateway.bean;

import java.io.Serializable;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 19:16
 * @description
 */
public class CaptchaBean implements Serializable{

    private String inputDate;
    private String SmsContent;
    private String SmsPort;
    private String SmsCode;

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getSmsContent() {
        return SmsContent;
    }

    public void setSmsContent(String smsContent) {
        SmsContent = smsContent;
    }

    public String getSmsPort() {
        return SmsPort;
    }

    public void setSmsPort(String smsPort) {
        SmsPort = smsPort;
    }

    public String getSmsCode() {
        return SmsCode;
    }

    public void setSmsCode(String smsCode) {
        SmsCode = smsCode;
    }
}
