package com.carryCompany.carryCompany.truck.application.inport;

import com.carryCompany.carryCompany.truck.application.service.dto.TruckResponse;
import com.carryCompany.carryCompany.truck.domain.Truck;

import java.util.List;

public interface ReadTruckService {
    List<TruckResponse.MainTruck> readAllTruck();

    Truck readTruckByBackNumber(String truckBackNumber);
}
