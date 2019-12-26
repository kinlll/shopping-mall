package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 产品属性表
 * */

@Entity
@Table(name = "t_attribute")
@Data
public class Attribute {

    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal price;
    private String name;
    private Integer memberProductId;
}
