package com.carryCompany.carryCompany.truck.application.outport;

import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.truck.domain.Truck;

import java.util.List;

public interface TruckReader {
    List<Truck> findAll();

    Truck findByTruckBackNumber(String truckBackNumber);
}
