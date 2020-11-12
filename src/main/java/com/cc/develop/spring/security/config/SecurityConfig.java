package com.cc.develop.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置登录异常跳转页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin() //自定义自己的登录页面
        .loginPage("/login.html") // 登录页面设置
        .loginProcessingUrl("/user/login") //登录访问路径
        .defaultSuccessUrl("/test/index").permitAll() //登录成功后，跳转路径
        .and().authorizeRequests()
                .antMatchers("/test/hello","/user/login").permitAll() //设置哪些路径可以直接访问不需要认证
                // 访问这个路径需要 admin的权限
                //.antMatchers("/test/index").hasAuthority("admin")
                // 当这个用户用于多个角色/权限时
                //.antMatchers("/test/index").hasAnyAuthority("admin,manager")
                // 当这个用户 有一个角色 功能同hasAuthority 这个方法底层会拼接一个ROLE_
                //.antMatchers("/test/index").hasRole("sale")
                // 用户有多个角色 功能同hasAnyAuthority
                .antMatchers("/test/index").hasAnyRole("admin,role,management")
                .anyRequest().authenticated()
        .and().csrf().disable() ;//关闭csrf防护
    }
}
