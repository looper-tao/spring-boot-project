package com.boot.security.config;

import com.boot.security.dao.UserMapper;
import com.boot.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/9/10
 * @description:
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    private final UserMapper userMapper;
    
    @Autowired
    public MyUserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<User> userList = userMapper.selectAll();
        return null;
    }
}
