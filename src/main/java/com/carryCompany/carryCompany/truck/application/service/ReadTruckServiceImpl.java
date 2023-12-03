package com.carryCompany.carryCompany.truck.application.service;

import com.carryCompany.carryCompany.truck.application.inport.ReadTruckService;
import com.carryCompany.carryCompany.truck.application.outport.TruckReader;
import com.carryCompany.carryCompany.truck.application.service.dto.TruckResponse;
import com.carryCompany.carryCompany.truck.domain.Truck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadTruckServiceImpl implements ReadTruckService {

    private final TruckReader truckReader;

    @Override
    public List<TruckResponse.MainTruck> readAllTruck() {
        List<Truck> truckList = truckReader.findAll();
        return truckList.stream().map(Truck::toResponse).toList();
    }
}
