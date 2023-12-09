package com.carryCompany.carryCompany.common.exception.vendor;

import com.carryCompany.carryCompany.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class VendorNotFoundException extends ApiException {
    public VendorNotFoundException() {
        super(HttpStatus.NOT_FOUND, "VENDOR_NOT_FOUND", "해당 제품을 찾을 수 없습니다.");
    }

}
