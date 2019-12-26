package com.example.shoppingmall.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_order")
@Data
public class Order {

    @Id
    @GeneratedValue
    private Integer id;
    private String address;
    //收货人
    private String receiver;
    private Integer mobile;
    //备注
    private String userMessage;
    private Integer consumerId;
    //预约时间
    private Date appointmentTime;
    @Column(columnDefinition = "char(1) comment '订单状态，0-未支付，1-已支付,2-已支付未确认收货,3-确认收货未评价,4-确认收货已评价,5-取消订单'")
    private String status;
    //确认收货日期
    private Date confirmDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}
