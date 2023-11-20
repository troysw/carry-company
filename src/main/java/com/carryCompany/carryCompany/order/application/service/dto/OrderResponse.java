package com.carryCompany.carryCompany.order.application.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class OrderResponse {

    @Data
    public static class MainOrderResponse {

        private int charge;
        private int consolidationCharge;
        private String vendorName;
        private LocalDateTime endDate;
        private LocalDateTime entranceDate;
        private String holidayCharge;
        private LocalDateTime landingDate;
        private String location;
        private String manager;
        private String marine;
        private String memo;
        private String orderCode;
        private String remarks;
        private String specialMemo;
        private LocalDateTime startDate;
        private String truckMemo;
        private String truckType;
        private String unitName;
        private String vendorOrderNumber;
        private String vessel;
        private String waitingCharge;
        private String vendorId;
        private String quantity;
        private String driverName;
        private String productItemName;
        private String truckBackNumber;
        private LocalDateTime loadingDate;
    }
}
