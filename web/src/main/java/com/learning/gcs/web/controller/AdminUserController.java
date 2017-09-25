package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    String home(Model model) {
        AdminUser adminUser =new AdminUser();
        adminUser.setId(1);
        adminUser.setPassword("密码");
        adminUser.setUserName("张三");
        adminUser.setUserLevel(1);
        adminUser.setUserType(1);
        model.addAttribute("user",adminUser);
        return "index";
    }
    @RequestMapping("/table")
    String table(Model model) {
        AdminUser adminUser =new AdminUser();
        adminUser.setId(1);
        adminUser.setPassword("密码");
        adminUser.setUserName("张三");
        adminUser.setUserLevel(1);
        adminUser.setUserType(1);
        model.addAttribute("user",adminUser);
        return "table";
    }
    @RequestMapping("/addTask")
    String addTask(Model model) {
        AdminUser adminUser =new AdminUser();
        adminUser.setId(1);
        adminUser.setPassword("密码");
        adminUser.setUserName("张三");
        adminUser.setUserLevel(1);
        adminUser.setUserType(1);
        model.addAttribute("user",adminUser);
        return "addTask";
    }

}
