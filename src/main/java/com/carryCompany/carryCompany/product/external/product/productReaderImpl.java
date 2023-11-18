package com.carryCompany.carryCompany.product.external.product;

import com.carryCompany.carryCompany.common.exception.product.ProductItemNotFoundException;
import com.carryCompany.carryCompany.common.exception.product.ProductNotFoundException;
import com.carryCompany.carryCompany.product.application.outport.ProductReader;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import com.carryCompany.carryCompany.product.domain.Product;
import com.carryCompany.carryCompany.product.domain.ProductItem;
import com.carryCompany.carryCompany.product.external.repository.ProductItemRepository;
import com.carryCompany.carryCompany.product.external.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class productReaderImpl implements ProductReader {

    private final ProductRepository productRepository;
    private final ProductItemRepository itemRepository;

    @Override
    public Page<ProductResponse.ProductCategoryResponse> readAllCategortList(Pageable pageable) {
        Page<Product> all = productRepository.findAll(pageable);

        List<ProductResponse.ProductCategoryResponse> res = all.stream().map(Product::toResponse).toList();

        return new PageImpl<>(res, all.getPageable(), all.getTotalElements());
    }

    @Override
    public Product readCategoryById(Long categoryId) {
        return productRepository.findById(categoryId).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductItem> readAllProductItemByProductId(Long id) {
        return itemRepository.findAllByProduct_productId(id);
    }

    @Override
    public Page<ProductItem> readAllItemList(Pageable pageable) {

        return itemRepository.findAll(pageable);
    }

    @Override
    public ProductItem readItemById(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(ProductItemNotFoundException::new);
    }

}
