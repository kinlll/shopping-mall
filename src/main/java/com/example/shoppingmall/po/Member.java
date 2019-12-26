package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 维修商家类
 * */

@Entity
@Table(name = "t_member")
@Data
public class Member {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false,unique = true)
    private String loginacct;
    @Column(nullable = false)
    private String userpswd;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    /*用户类型*/
    @Column(columnDefinition = "char(1) comment ' 0 - 个人， 1 - 店铺'",nullable = false)
    private String usertype;
    private String realname;
    private String cardnum;
    private String tel;
    /*用户认证状态*/
    @Column(columnDefinition = "char(1) comment '实名认证状态 0 - 未实名认证， 1 - 实名认证申请中， 2 - 已实名认证'",nullable = false)
    private String authstatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Transient
    private List<Cert> memberCert;
}
