package com.cc.develop.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * com.cc.develop.spring.security.config
 *
 * @author changchen
 * @email java@mail.com
 * @date 2020-11-10 08:40:23
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//表单登录
        .and().authorizeRequests()//认证配置
        .anyRequest()//任何请求
        .authenticated();
    }
}
