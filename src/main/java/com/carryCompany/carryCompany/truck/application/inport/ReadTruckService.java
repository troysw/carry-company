package com.carryCompany.carryCompany.truck.application.inport;

import com.carryCompany.carryCompany.truck.application.service.dto.TruckResponse;

import java.util.List;

public interface ReadTruckService {
    List<TruckResponse.MainTruck> readAllTruck();
}
