package com.example.shoppingmall.dao;

import com.example.shoppingmall.po.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
