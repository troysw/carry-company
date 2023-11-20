package com.carryCompany.carryCompany.order.application.inport;

import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;

import java.util.List;

public interface ReadOrderService {
    List<OrderResponse.MainOrderResponse> readAllOrder();
}
