package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.*;

/**
 * 店铺运营日期（按星期）
 * */

@Entity
@Table(name = "t_week")
@Data
public class Week {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer memberId;
    @Column(columnDefinition = "char(1) comment '运营状态 1 - 运营， 2 - 不运营'", nullable = false)
    private String monday;
    @Column(columnDefinition = "char(1) comment '运营状态 1 - 运营， 2 - 不运营'", nullable = false)
    private String tuesday;
    @Column(columnDefinition = "char(1) comment '运营状态 1 - 运营， 2 - 不运营'", nullable = false)
    private String wednesday;
    @Column(columnDefinition = "char(1) comment '运营状态 1 - 运营， 2 - 不运营'", nullable = false)
    private String thursday;
    @Column(columnDefinition = "char(1) comment '运营状态 1 - 运营， 2 - 不运营'", nullable = false)
    private String friday;
    @Column(columnDefinition = "char(1) comment '运营状态 1 - 运营， 2 - 不运营'", nullable = false)
    private String saturday;
    @Column(columnDefinition = "char(1) comment '运营状态 1 - 运营， 2 - 不运营'", nullable = false)
    private String sunday;
}
