package com.example.shoppingmall.service.admin;

import com.example.shoppingmall.po.Scategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ScategoryService {

    List<Scategory> getByCategoryId(Integer categoryId);

    Page<Scategory> getAll(Pageable pageable);

    Scategory getById(Integer id);

    Scategory getByName(String name);

    void add(Scategory scategory);
}
