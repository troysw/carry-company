package com.carryCompany.carryCompany.order.application.service;

import com.carryCompany.carryCompany.order.application.inport.OrderService;
import com.carryCompany.carryCompany.order.application.inport.ReadOrderService;
import com.carryCompany.carryCompany.order.application.outport.OrderReader;
import com.carryCompany.carryCompany.order.application.outport.OrderStore;
import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderReader orderReader;
    private final OrderStore orderStore;


    @Override
    public void createMainOrder(List<MainOrderRequest.MainOrderCreateRequest> request) {
//        MainOrder order = MainOrder.create(request);
//        orderStore.saveMainOrder(order);
    }
}
