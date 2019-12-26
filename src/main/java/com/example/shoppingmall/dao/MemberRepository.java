package com.example.shoppingmall.dao;

import com.example.shoppingmall.po.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("select m from Member m where m.authstatus = 1")
    Page<Member> findUnauthorizedMember(Pageable pageable);
}
