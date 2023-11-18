package com.carryCompany.carryCompany.product.application.inport;

import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;

public interface ProductService {
    void createCategory(ProductRequest.categoryCreate request);

    void updateCategory(ProductRequest.categoryUpdate request);

    void deleteCategory(Long id);

    void createItem(ProductRequest.itemCreate request);

    void updateItem(ProductRequest.itemUpdate request);
}
