package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户收藏
 * */
@Entity
@Table(name = "t_collect")
@Data
public class Collect {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer consumerId;
    private Integer memberProductId;
}
