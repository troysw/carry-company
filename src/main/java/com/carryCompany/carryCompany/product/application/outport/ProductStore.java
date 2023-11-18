package com.carryCompany.carryCompany.product.application.outport;

import com.carryCompany.carryCompany.product.domain.Product;
import com.carryCompany.carryCompany.product.domain.ProductItem;

import java.util.List;

public interface ProductStore {
    void save(Product product);

    void deleteAllProductItemList(List<ProductItem> productItemList);

    void deleteProduct(Product product);

    void saveItem(ProductItem item);
}
