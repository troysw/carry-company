package com.carryCompany.carryCompany.truck.application.service;

import com.carryCompany.carryCompany.order.application.inport.OrderService;
import com.carryCompany.carryCompany.order.application.outport.OrderReader;
import com.carryCompany.carryCompany.order.application.outport.OrderStore;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.truck.application.inport.TruckService;
import com.carryCompany.carryCompany.truck.application.outport.TruckReader;
import com.carryCompany.carryCompany.truck.application.outport.TruckStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {

    private final TruckReader truckReader;
    private final TruckStore truckStore;


}
