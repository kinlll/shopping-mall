package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实名认证需提交资料
 * */

@Entity
@Table(name = "t_cert")
@Data
public class Cert {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
