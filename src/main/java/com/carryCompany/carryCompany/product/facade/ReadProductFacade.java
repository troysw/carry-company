package com.carryCompany.carryCompany.product.facade;

import com.carryCompany.carryCompany.product.application.inport.ReadProductService;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReadProductFacade {

    private final ReadProductService readProductService;

    public Page<ProductResponse.ProductCategoryResponse> readCategoryList(Pageable pageable) {
        return readProductService.readAllCategoryList(pageable);
    }

    public Page<ProductResponse.ProductItemResponse> readItemList(Pageable pageable) {
        return readProductService.readAllItemList(pageable);
    }
}
