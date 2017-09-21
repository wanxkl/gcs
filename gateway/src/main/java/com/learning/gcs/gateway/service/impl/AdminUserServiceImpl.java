package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.AdminUser;
import com.learning.gcs.common.repository.AdminUserRepository;
import com.learning.gcs.gateway.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/9/22 3:20
 * @description
 */
@Service
public class AdminUserServiceImpl implements AdminUserService{
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public void save(AdminUser adminUser) {
        adminUserRepository.save(adminUser);
    }
}
