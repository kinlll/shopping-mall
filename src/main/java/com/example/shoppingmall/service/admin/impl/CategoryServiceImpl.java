package com.example.shoppingmall.service.admin.impl;

import com.example.shoppingmall.dao.CategoryRepository;
import com.example.shoppingmall.po.Category;
import com.example.shoppingmall.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }
}
