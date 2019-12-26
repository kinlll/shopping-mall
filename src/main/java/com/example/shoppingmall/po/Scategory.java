package com.example.shoppingmall.po;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * 小分类
 * */

@Entity
@Table(name = "t_scategory")
@Data
public class Scategory {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer categoryId;
    private String iconpath;

    @Transient
    private Page<MemberProduct> memberProductPage;

    @Transient
    private MultipartFile fileimg;
}
