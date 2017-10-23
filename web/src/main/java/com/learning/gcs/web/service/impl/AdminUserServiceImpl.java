package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.AdminRole;
import com.learning.gcs.common.entity.AdminUser;
import com.learning.gcs.common.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 11:43
 * @description
 */
@Service
public class AdminUserServiceImpl implements UserDetailsService{

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser =  adminUserRepository.findByUsername(username);

        if(adminUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<GrantedAuthority> auths = new ArrayList<>();
        List<AdminRole> roles = adminUser.getRoles();
        for (AdminRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(adminUser.getUsername(),
                        adminUser.getPassword(),auths);

    }

}
