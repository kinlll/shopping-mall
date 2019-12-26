package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品类
 * */

@Entity
@Table(name = "t_member_product")
@Data
public class MemberProduct {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private BigDecimal basicPrice;
    @Column(columnDefinition = "char(1) comment ' 0 - 上架， 1 - 下架'")
    private String status;
    private Integer sales;
    private String category_num;
    private String icon;
    //所属小分类
    private Integer scategoryId;
    //详细信息
    private String details;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;



}
