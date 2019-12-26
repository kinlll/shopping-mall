package com.example.shoppingmall.dao;

import com.example.shoppingmall.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLoginacctAndUserpswd(String loginacct, String userpswd);
}
