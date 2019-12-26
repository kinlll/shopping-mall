package com.example.shoppingmall.service.admin;

import com.example.shoppingmall.po.MemberCert;

import java.util.List;

public interface MemberCertService {

    List<MemberCert> getByMemberId(Integer memberId);
}
