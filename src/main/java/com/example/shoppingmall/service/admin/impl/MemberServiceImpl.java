package com.example.shoppingmall.service.admin.impl;

import com.example.shoppingmall.dao.MemberRepository;
import com.example.shoppingmall.po.Member;
import com.example.shoppingmall.service.admin.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Page<Member> getUnauthorizedMember(Pageable pageable) {
        return memberRepository.findUnauthorizedMember(pageable);
    }

    @Override
    public Member getMemberById(Integer id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }
}
