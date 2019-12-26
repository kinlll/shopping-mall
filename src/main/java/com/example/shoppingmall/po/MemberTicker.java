package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.*;

/**
 * 商家注册表
 * */

@Entity
@Table(name = "t_member_Ticker")
@Data
public class MemberTicker {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer memberId;
    private Integer regCode;
    @Column(columnDefinition = "char(1) comment ' 0 - 未实名， 1 - 已实名'")
    private String status;
    //流程号
    private String piId;
    //认证步骤
    private String pstep;
}
