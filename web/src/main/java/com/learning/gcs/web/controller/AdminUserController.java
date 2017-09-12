package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/9/13 1:30
 * @description
 */
@Controller
public class AdminUserController {
    @RequestMapping("/")
    @ResponseBody
    AdminUser home() {
        AdminUser adminUser =new AdminUser();
        adminUser.setId(1);
        adminUser.setPassword("password");
        adminUser.setUserName("username");
        adminUser.setUserLevel(1);
        adminUser.setUserType(1);
        return adminUser;
    }
}
