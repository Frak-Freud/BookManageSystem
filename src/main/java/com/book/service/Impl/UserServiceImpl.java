package com.book.service.Impl;

import com.book.entity.Account;
import com.book.mapper.UserMapper;
import com.book.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userMapper.getUserByName(username);
        if (account == null)
            throw new UsernameNotFoundException("用户名或密码错误");
        System.out.println("account: " + account);
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();

    }
}
