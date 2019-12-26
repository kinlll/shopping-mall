package com.example.shoppingmall.po;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

/**
 * 大分类
 * */

@Entity
@Table(name = "t_category")
@Data
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String iconpath;


    @Transient
    private List<Scategory> scategories;

    @Transient
    private MultipartFile fileimg;

}
