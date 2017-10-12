package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.util.HttpUtil;
import com.learning.gcs.gateway.bean.PhoneCaptchaBean;
import com.learning.gcs.gateway.service.PhoneCaptchaService;
import com.learning.gcs.gateway.util.CaptchaUtil;
import com.learning.gcs.gateway.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 20:55
 * @description
 */
@Service
public class PhoneCaptchaServiceImpl implements PhoneCaptchaService{

    private static final Logger logger = LoggerFactory.getLogger(PhoneCaptchaServiceImpl.class);

    private final static String uid = "dfdtech";
    private final static String pwd = "5084350";

    private static String HOST_LOGIN = "http://yima888.com/http.aspx?action=loginIn&uid={uid}&pwd={pwd}";
    private static String HOST_GET_PHONE = "http://yima888.com/http.aspx?action=getMobilenum&pid={pid}&uid={uid}&token={token}&size=1";
    private static String HOST_GET_CAPTCHA = "http://yima888.com/http.aspx?action=getVcodeAndHoldMobilenum&uid={uid}&token={token}&pid={pid}&mobile={mobile}";

    private static String token = null;


    @Override
    public PhoneCaptchaBean getPhoneNumber(Integer taskId) {

        init();

        String pid = "15237";

        String urlGetPhone = HOST_GET_PHONE.replace("{uid}",uid).replace("{pid}",pid).replace("{token}",token);
        logger.info("urlGetPhone:{}",urlGetPhone);
        String retGetPhone = HttpUtil.sendGet(urlGetPhone,Constant.CHARSET);
        logger.info("retGetPhone:{}",retGetPhone);
        if(retGetPhone.indexOf("|")>-1){
            String phoneNumber =  retGetPhone.split("\\|")[0];

            PhoneCaptchaBean  phoneCaptchaBean = new PhoneCaptchaBean().buildPhoneNumber(phoneNumber);
            return phoneCaptchaBean;
        }

        return new PhoneCaptchaBean();
    }

    @Override
    public PhoneCaptchaBean getPhoneCaptcha(Integer taskId,String phoneNumber) {
        init();
        String pid = "15237";

        String urlGetCaptcha = HOST_GET_CAPTCHA.replace("{uid}",uid).replace("{pid}",pid).replace("{token}",token).replace("{mobile}",phoneNumber);
        logger.info("urlGetCaptcha:{}",urlGetCaptcha);

        String retGetCaptcha = HttpUtil.sendGet(urlGetCaptcha,Constant.CHARSET);
        logger.info("retGetCaptcha:{}",retGetCaptcha);

        if(retGetCaptcha.indexOf("|")>-1){
            String captchaContent =  retGetCaptcha.split("\\|")[1];
            String captcha = CaptchaUtil.getCaptcha(captchaContent,6);
            if(StringUtils.isEmpty(captcha)){
                captcha = CaptchaUtil.getCaptcha(captchaContent,4);
            }
            PhoneCaptchaBean  phoneCaptchaBean = new PhoneCaptchaBean().buildCaptcha(captcha);
            return phoneCaptchaBean;
        }

        return new PhoneCaptchaBean();
    }

    private void init(){
        if (StringUtils.isEmpty(token)){
            String urlLogin = HOST_LOGIN.replace("{uid}",uid).replace("{pwd}",pwd);
            logger.info("urlLogin:{}",urlLogin);
            String loginRet = HttpUtil.sendGet(urlLogin, Constant.CHARSET);
            logger.info("loginRet:{}",loginRet);

            token = loginRet.split("\\|")[1];
        }
    }


}
