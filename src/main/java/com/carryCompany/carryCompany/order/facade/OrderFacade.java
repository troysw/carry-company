package com.carryCompany.carryCompany.order.facade;

import com.carryCompany.carryCompany.order.application.inport.OrderService;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderFacade {

    private final OrderService orderService;

    public void createMainOrder(List<MainOrderRequest.MainOrderCreateRequest> request) {
        orderService.createMainOrder(request);
    }
}
