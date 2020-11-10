package com.cc.develop.spring.security.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * com.cc.develop.spring.security.service
 *
 * @author changchen
 * @email java@mail.com
 * @date 2020-11-10 10:11:05
 */
@Service
public class LoginService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //判断用户名是否存在
        if (!"root".equals(username)){
            throw new UsernameNotFoundException("用户名不存在");
        }

        //todo 后面需要修改成从数据库中查询的密码
        String pwd = "$2a$10$gp6TS0S8qDLv0/mCm3/LfeqWKEGzUzhVzxBwPVHDM71k48FCoP7P6";

        return new User(username,pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

    }
}
