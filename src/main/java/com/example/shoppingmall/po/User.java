package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 管理员表
 * */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String loginacct;
    private String userpswd;
    private String username;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

}
