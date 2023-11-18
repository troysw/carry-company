package com.carryCompany.carryCompany.product.application.outport;

import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import com.carryCompany.carryCompany.product.domain.Product;
import com.carryCompany.carryCompany.product.domain.ProductItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductReader {
    Page<ProductResponse.ProductCategoryResponse> readAllCategortList(Pageable pageable);

    Product readCategoryById(Long categoryId);

    List<ProductItem> readAllProductItemByProductId(Long id);

    Page<ProductItem> readAllItemList(Pageable pageable);

    ProductItem readItemById(Long itemId);
}
