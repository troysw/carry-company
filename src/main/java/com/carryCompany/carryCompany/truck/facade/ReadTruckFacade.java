package com.carryCompany.carryCompany.truck.facade;

import com.carryCompany.carryCompany.order.application.inport.ReadOrderService;
import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.truck.application.inport.ReadTruckService;
import com.carryCompany.carryCompany.truck.application.service.dto.TruckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReadTruckFacade {

    private final ReadTruckService readTruckService;

    public List<TruckResponse.MainTruck> readAllTruck() {
        return readTruckService.readAllTruck();

    }
}
