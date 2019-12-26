package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品图片类
 * */

@Entity
@Table(name = "t_product_image")
@Data
public class ProductImage {

    @Id
    @GeneratedValue
    private Integer id;
    private String iconpath1;
    private String iconpath2;
    private String iconpath3;
    private String iconpath4;
    private String iconpath5;
    private Integer memberProductId;
}
