package com.carryCompany.carryCompany.order.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainOrderRequest {
    @Data
    public static class MainOrderCreateRequest {
        private String humanCode;
        private String workingDay;
        private String vendorName;
        private String manager;
        private String orderCode;
        private String productItemName;
        private String unitName;
        private int quantity;
        private String marine;
        private String vessel;
        private String location;
        private String landingDate;
        private String landingTime;
        private String startDate;
        private String startTime;
        private String vendorOrderNumber;
        private String remarks;
        private String loadingDate;
        private String truckBackNumber;
        private String uploadingDate;
        private String truckFullNumber;
        private int holidayCharge;
        private int waitingCharge;
        private int consolidationCharge;
        private int charge;
        private String driverName;
        private int otherCharge;
        private int finalCharge;
        private String personalTruckFullNumber;
        private int personalCharge;
        private String personalDriverName;
        private int personalHolidayCharge;
        private int personalWaitingCharge;
        private int personalOtherCharge;
        private int personalFinalCharge;
        private String personalSpecialMemo;
        private String memo;
        private String specialMemo;
        private String endDate;
        private String entranceDate;
        private String truckMemo;
        private String truckType;
        private Long vendorId;
        private String tripManage;
    }
}
