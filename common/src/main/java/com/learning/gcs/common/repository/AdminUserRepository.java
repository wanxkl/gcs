package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.AdminUser;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/9/22 3:12
 * @description
 */
public interface AdminUserRepository extends MyRepository<AdminUser,Integer>{

    AdminUser findByUserName(String userName);
}
