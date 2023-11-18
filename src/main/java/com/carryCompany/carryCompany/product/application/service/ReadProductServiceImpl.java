package com.carryCompany.carryCompany.product.application.service;

import com.carryCompany.carryCompany.product.application.inport.ReadProductService;
import com.carryCompany.carryCompany.product.application.outport.ProductReader;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import com.carryCompany.carryCompany.product.domain.ProductItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadProductServiceImpl implements ReadProductService {

    private final ProductReader productReader;


    @Override
    public Page<ProductResponse.ProductCategoryResponse> readAllCategoryList(Pageable pageable) {
        return productReader.readAllCategortList(pageable);
    }

    @Override
    public Page<ProductResponse.ProductItemResponse> readAllItemList(Pageable pageable) {
        Page<ProductItem> itemList = productReader.readAllItemList(pageable);
        List<ProductResponse.ProductItemResponse> list = itemList.stream().map(ProductItem::toResponse).toList();
        return new PageImpl<>(list, itemList.getPageable(), itemList.getTotalElements());
    }
}
