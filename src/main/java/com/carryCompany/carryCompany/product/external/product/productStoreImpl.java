package com.carryCompany.carryCompany.product.external.product;

import com.carryCompany.carryCompany.product.application.outport.ProductStore;
import com.carryCompany.carryCompany.product.domain.Product;
import com.carryCompany.carryCompany.product.domain.ProductItem;
import com.carryCompany.carryCompany.product.external.repository.ProductItemRepository;
import com.carryCompany.carryCompany.product.external.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class productStoreImpl implements ProductStore {

    private final ProductRepository productRepository;
    private final ProductItemRepository itemRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteAllProductItemList(List<ProductItem> productItemList) {
        itemRepository.deleteAll(productItemList);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
