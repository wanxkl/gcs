package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(method = RequestMethod.GET)
    String doTest(){
        System.out.println(adminUserService);
        return null;
    }
}
