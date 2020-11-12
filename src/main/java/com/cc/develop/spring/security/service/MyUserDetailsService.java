package com.cc.develop.spring.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.develop.spring.security.entity.Users;
import com.cc.develop.spring.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.cc.develop.spring.security.service
 *
 * @author changchen
 * @email java@mail.com
 * @date 2020-11-10 10:32:58
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Users users = userMapper.selectOne(queryWrapper);
        if (users == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),authorities);

    }
}
