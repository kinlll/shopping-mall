package com.example.shoppingmall.service.admin.impl;

import com.example.shoppingmall.dao.CertRepository;
import com.example.shoppingmall.po.Cert;
import com.example.shoppingmall.service.admin.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CerServiceImpl implements CertService {

    @Autowired
    private CertRepository certRepository;

    @Override
    public Cert getById(Integer certId) {
        return certRepository.findById(certId).orElse(null);
    }
}
