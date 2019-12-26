package com.example.shoppingmall.dao;

import com.example.shoppingmall.po.MemberCert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberCertRepository extends JpaRepository<MemberCert, Integer> {

    List<MemberCert> findByMemberId(Integer memberId);
}
