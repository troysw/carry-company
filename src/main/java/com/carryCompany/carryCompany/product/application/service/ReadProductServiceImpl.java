package com.carryCompany.carryCompany.product.application.service;

import com.carryCompany.carryCompany.product.application.inport.ReadProductService;
import com.carryCompany.carryCompany.product.application.outport.ProductReader;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadProductServiceImpl implements ReadProductService {

    private final ProductReader productReader;


    @Override
    public Page<ProductResponse.ProductCategoryResponse> readAllCategoryList(Pageable pageable) {
        return productReader.readAllCategortList(pageable);
    }
}
