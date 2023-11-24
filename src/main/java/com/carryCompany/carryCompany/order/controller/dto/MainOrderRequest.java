package com.carryCompany.carryCompany.order.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainOrderRequest {
    @Data
    public static class MainOrderCreateRequest {
        private String vendorName;
        private String manager;
        private String orderCode;
        private String productItemName;
        private String unitName;
        private String quantity;
        private String marine;
        private String vessel;
        private String location;
        private LocalDate landingDate;
        private String landingTime;
        private String startDate;
        private String startTime;
        private String vendorOrderNumber;
        private String remarks;
        private String loadingDate;
        private String truckBackNumber;
        private String charge;
        private String consolidationCharge;
        private String endDate;
        private String entranceDate;
        private String holidayCharge;
        private String memo;
        private String specialMemo;
        private String truckMemo;
        private String truckType;
        private String waitingCharge;
        private String driverName;
        private String vendorId;
    }
}
