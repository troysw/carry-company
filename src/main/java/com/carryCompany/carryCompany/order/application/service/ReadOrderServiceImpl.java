package com.carryCompany.carryCompany.order.application.service;

import com.carryCompany.carryCompany.order.application.inport.ReadOrderService;
import com.carryCompany.carryCompany.order.application.outport.OrderReader;
import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReadOrderServiceImpl implements ReadOrderService {

    private final OrderReader orderReader;

    @Override
    public List<OrderResponse.MainOrderResponse> readAllOrder() {
        List<MainOrder> allOrder = orderReader.findAllOrder();
        return allOrder.stream().map(MainOrder::toResponse).collect(Collectors.toList());

    }
}
