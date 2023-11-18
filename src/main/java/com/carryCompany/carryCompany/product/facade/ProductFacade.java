package com.carryCompany.carryCompany.product.facade;

import com.carryCompany.carryCompany.common.security.Security;
import com.carryCompany.carryCompany.customer.service.CustomerService;
import com.carryCompany.carryCompany.product.application.inport.ProductService;
import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductFacade {

    private final ProductService productService;
    private final CustomerService customerService;
    private final Security security;

    public void createCategory(ProductRequest.categoryCreate request) {
        productService.create(request);
    }

    @Transactional
    public void updateCategory(ProductRequest.categoryUpdate request) {
        productService.update(request);
    }

    public void deleteCategory(Long id) {
        productService.delete(id);
    }
}
