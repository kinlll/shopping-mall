package com.example.shoppingmall.service.admin.impl;

import com.example.shoppingmall.dao.ScategoryRepository;
import com.example.shoppingmall.po.Scategory;
import com.example.shoppingmall.service.admin.ScategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScategoryServiceImpl implements ScategoryService {

    @Autowired
    private ScategoryRepository scategoryRepository;

    @Override
    public List<Scategory> getByCategoryId(Integer categoryId) {
        return scategoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public Page<Scategory> getAll(Pageable pageable) {
        return scategoryRepository.findAll(pageable);
    }

    @Override
    public Scategory getById(Integer id) {
        return scategoryRepository.findById(id).orElse(null);
    }

    @Override
    public Scategory getByName(String name) {
        return scategoryRepository.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void add(Scategory scategory) {
        scategoryRepository.save(scategory);
    }
}
