package com.learning.gcs.web.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 11:41
 * @description
 */
@Component
public class SecurityComponent {

    @Configuration
    public class WebMvcConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");
        }
    }

    @Configuration
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsService userDetailsService;
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers(new String[]{"/js/**","/css/**","/img/**","/images/**","/fonts/**","/**/favicon.ico"}).permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginPage("/login").permitAll()
                    .and().logout().logoutSuccessUrl("/login").permitAll()
                    .and().headers().frameOptions().sameOrigin()
                    .and().csrf().disable();
        }

    }
}
