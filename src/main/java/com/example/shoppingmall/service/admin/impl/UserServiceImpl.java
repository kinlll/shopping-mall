package com.example.shoppingmall.service.admin.impl;

import com.example.shoppingmall.dao.UserRepository;
import com.example.shoppingmall.po.User;
import com.example.shoppingmall.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String loginacct, String userpswd) {
        User user = userRepository.findByLoginacctAndUserpswd(loginacct, userpswd);
        return user;
    }
}
