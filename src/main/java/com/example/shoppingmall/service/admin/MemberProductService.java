package com.example.shoppingmall.service.admin;

import com.example.shoppingmall.po.MemberProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberProductService {

    Page<MemberProduct> getAll(Pageable pageable);
}
