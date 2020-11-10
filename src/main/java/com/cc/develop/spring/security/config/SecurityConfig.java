package com.cc.develop.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * com.cc.develop.spring.security.config
 *
 * @author changchen
 * @email java@mail.com
 * @date 2020-11-10 10:02:14
 * 配置PasswordEncoder密码解析器
 */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
