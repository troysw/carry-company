package com.carryCompany.carryCompany.product.application.service;

import com.carryCompany.carryCompany.product.application.inport.ProductService;
import com.carryCompany.carryCompany.product.application.outport.ProductReader;
import com.carryCompany.carryCompany.product.application.outport.ProductStore;
import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;
import com.carryCompany.carryCompany.product.domain.Product;
import com.carryCompany.carryCompany.product.domain.ProductItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductReader productReader;
    private final ProductStore productStore;

    @Override
    public void create(ProductRequest.categoryCreate request) {
      Product product = Product.create(request);
      productStore.save(product);
    }

    @Override
    public void update(ProductRequest.categoryUpdate request) {
        Product product = productReader.readCategoryById(request.getProductId());
        product.update(request);
    }

    @Override
    public void delete(Long id) {
        Product product = productReader.readCategoryById(id);
        List<ProductItem> productItemList = productReader.readAllProductItemByProductId(id);
        productStore.deleteAllProductItemList(productItemList);
        productStore.deleteProduct(product);

    }
}
