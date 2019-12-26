package com.example.shoppingmall.service.admin;

import com.example.shoppingmall.po.User;

public interface UserService {

    User checkUser(String loginacct, String userpswd);
}
