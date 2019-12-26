package com.example.shoppingmall.vo;

import com.example.shoppingmall.po.Member;
import com.example.shoppingmall.po.MemberCert;

import java.util.List;


public class MemberExamineVo {

    private Member member;
    private List<MemberCert> memberCerts;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<MemberCert> getMemberCerts() {
        return memberCerts;
    }

    public void setMemberCerts(List<MemberCert> memberCerts) {
        this.memberCerts = memberCerts;
    }
}
