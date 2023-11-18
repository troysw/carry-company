package com.carryCompany.carryCompany.product.application.inport;

import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;

public interface ProductService {
    void create(ProductRequest.categoryCreate request);

    void update(ProductRequest.categoryUpdate request);

    void delete(Long id);
}
