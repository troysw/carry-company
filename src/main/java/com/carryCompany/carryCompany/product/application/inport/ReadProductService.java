package com.carryCompany.carryCompany.product.application.inport;

import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadProductService {
    Page<ProductResponse.ProductCategoryResponse> readAllCategoryList(Pageable pageable);
}
