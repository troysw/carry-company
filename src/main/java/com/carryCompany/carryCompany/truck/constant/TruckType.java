package com.carryCompany.carryCompany.truck.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TruckType {
        DIRECT("직영"),
        PERSONAL("지입");

        private final String value;

}
