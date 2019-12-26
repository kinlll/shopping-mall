package com.example.shoppingmall.dao;

import com.example.shoppingmall.po.MemberProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberProductRepository extends JpaRepository<MemberProduct, Integer> {
}
