package com.carryCompany.carryCompany.common.exception.product;

import com.carryCompany.carryCompany.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductItemNotFoundException extends ApiException {
    public ProductItemNotFoundException() {
        super(HttpStatus.NOT_FOUND, "PRODUCT_NOT_FOUND", "해당 제품을 찾을 수 없습니다.");
    }

}
