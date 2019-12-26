package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商家地址类
 * */

@Entity
@Table(name = "t_address")
@Data
public class MemberAddress {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer memberId;
    private String address;
}
