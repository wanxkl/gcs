package com.learning.gcs.web.controller;

import com.learning.gcs.common.entity.AdminUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/9/13 1:30
 * @description
 */
@Controller
public class AdminUserController {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);
    @RequestMapping("/")
    String home(Model model) {
        AdminUser adminUser =new AdminUser();
        adminUser.setId(1);
        adminUser.setPassword("密码");
        adminUser.setUsername("张三");
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
        adminUser.setUsername("张三");
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
        adminUser.setUsername("张三");
        adminUser.setUserLevel(1);
        adminUser.setUserType(1);
        model.addAttribute("user",adminUser);
        return "addTask";
    }
    @RequestMapping("/home")
    String rehome(Model model) {
        AdminUser adminUser =new AdminUser();
        adminUser.setId(1);
        adminUser.setPassword("密码");
        adminUser.setUsername("张三");
        adminUser.setUserLevel(1);
        adminUser.setUserType(1);
        model.addAttribute("user",adminUser);
        return "home";
    }
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    String login(@RequestParam String userName, @RequestParam String password, Model model){
//        logger.info("login post");
//        UserDetails userDetails =  userDetailsService.loadUserByUsername(userName);
//
//        if(password.equals(userDetails.getPassword())){
//            model.addAttribute("userDetails",userDetails);
//        }else{
//            model.addAttribute("error","账号或密码不正确");
//        }
//        return "index";
//
//    }
//
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    String login(){
//        logger.info("login get");
//        return "login";
//    }
//
//    @RequestMapping(value = "/home",method = RequestMethod.GET)
//    String home(){
//        logger.info("home get");
//        return "home";
//    }
}
