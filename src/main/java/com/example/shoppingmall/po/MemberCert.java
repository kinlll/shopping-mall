package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_member_cert")
@Data
public class MemberCert {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer memberId;
    private Integer certId;
    private String iconpath;

    @Transient
    private String certName;
}
