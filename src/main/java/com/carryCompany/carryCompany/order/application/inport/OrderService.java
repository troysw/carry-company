package com.carryCompany.carryCompany.order.application.inport;

import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;

import java.util.List;

public interface OrderService {
    void createMainOrder(List<MainOrderRequest.MainOrderCreateRequest> request);
}
