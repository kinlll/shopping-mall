package com.example.shoppingmall.service.admin.impl;

import com.example.shoppingmall.dao.MemberProductRepository;
import com.example.shoppingmall.po.MemberProduct;
import com.example.shoppingmall.service.admin.MemberProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberProductServiceImpl implements MemberProductService {

    @Autowired
    private MemberProductRepository memberProductRepository;

    @Override
    public Page<MemberProduct> getAll(Pageable pageable) {
        return memberProductRepository.findAll(pageable);
    }
}
