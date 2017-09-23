package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.AdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserServiceTest {

    @Autowired
    private AdminUserService adminUserService;


    @Test
    public void printBean() throws Exception {
        System.out.println(adminUserService);
    }

    @Test
    public void save() throws Exception {

        AdminUser adminUser = new AdminUser();
        adminUser.setUserName("xll");
        adminUser.setPassword("xll");
        adminUser.setUserLevel(1);
        adminUser.setUserType(1);

        adminUserService.save(adminUser);
    }

}