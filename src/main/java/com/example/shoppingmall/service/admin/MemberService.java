package com.example.shoppingmall.service.admin;

import com.example.shoppingmall.po.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    Page<Member> getUnauthorizedMember(Pageable pageable);

    Member getMemberById(Integer id);

    void save(Member member);
}
