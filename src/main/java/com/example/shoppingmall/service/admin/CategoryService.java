package com.example.shoppingmall.service.admin;

import com.example.shoppingmall.po.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<Category> getAll(Pageable pageable);

    Category getById(Integer id);

    Category getByName(String name);

    void add(Category category);
}
