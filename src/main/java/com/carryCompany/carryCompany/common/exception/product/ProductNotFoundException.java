package com.carryCompany.carryCompany.common.exception.product;

import com.carryCompany.carryCompany.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductNotFoundException extends ApiException {
    public ProductNotFoundException() {
        super(HttpStatus.NOT_FOUND, "PRODUCT_NOT_FOUND", "해당 카테고리를 찾을 수 없습니다.");
    }

}
