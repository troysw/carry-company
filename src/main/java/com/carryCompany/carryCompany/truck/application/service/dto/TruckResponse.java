package com.carryCompany.carryCompany.truck.application.service.dto;

import com.carryCompany.carryCompany.truck.constant.TruckType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TruckResponse {
    @Data
    public static class MainTruck {
        private Long id;
        private String truckBackNumber;
        private String truckFullNumber;
        private String driverName;
        private TruckType truckType;
    }
}
