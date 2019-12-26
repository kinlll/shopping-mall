package com.example.shoppingmall.service.admin.impl;

import com.example.shoppingmall.dao.MemberCertRepository;
import com.example.shoppingmall.po.MemberCert;
import com.example.shoppingmall.service.admin.MemberCertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberCertImpl implements MemberCertService {

    @Autowired
    private MemberCertRepository memberCertRepository;


    @Override
    public List<MemberCert> getByMemberId(Integer memberId) {
        return memberCertRepository.findByMemberId(memberId);
    }
}
