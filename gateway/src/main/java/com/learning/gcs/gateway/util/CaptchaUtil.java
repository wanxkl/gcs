package com.learning.gcs.gateway.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2016/10/18 15:21
 * @description
 */
public class CaptchaUtil {

    public static String getCaptcha(String message,int captchaLength) {
        // 首先([a-zA-Z0-9]{YZMLENGTH})是得到一个连续的六位数字字母组合
        // (?<![a-zA-Z0-9])负向断言([0-9]{YZMLENGTH})前面不能有数字
        // (?![a-zA-Z0-9])断言([0-9]{YZMLENGTH})后面不能有数字出现

//  获得数字字母组合
//    Pattern p = Pattern   .compile("(?<![a-zA-Z0-9])([a-zA-Z0-9]{" + YZMLENGTH + "})(?![a-zA-Z0-9])");

//  获得纯数字
        Pattern p = Pattern.compile("(?<![0-9])([0-9]{" + captchaLength+ "})(?![0-9])");
        Matcher m = p.matcher(message);
        if (m.find()) {
            return m.group(0);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getCaptcha("欢迎注册国泰君安君弘，您的手机验证码：8729。请确保之后的开户操作均由您本人进行，如有疑问请致电95521客服中心，谢谢！【国泰君安】",6));
        System.out.println(getCaptcha("尊敬的客户，本次验证码298522，请勿泄露，如有疑问请致电95521客服中心，谢谢！【国泰君安】",6));
    }

}
