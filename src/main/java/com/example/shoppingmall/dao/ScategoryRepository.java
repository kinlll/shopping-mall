package com.example.shoppingmall.dao;

import com.example.shoppingmall.po.Scategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScategoryRepository extends JpaRepository<Scategory, Integer> {

    List<Scategory> findByCategoryId(Integer categoryId);

    Scategory findByName(String name);
}
