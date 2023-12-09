package com.carryCompany.carryCompany.common.exception.truck;

import com.carryCompany.carryCompany.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TruckNotFoundException extends ApiException {
    public TruckNotFoundException() {
        super(HttpStatus.NOT_FOUND, "TRUCK_NOT_FOUND", "해당 차량을 찾을 수 없습니다.");
    }

}
