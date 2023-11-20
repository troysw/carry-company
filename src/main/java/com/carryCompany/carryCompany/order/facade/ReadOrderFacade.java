package com.carryCompany.carryCompany.order.facade;

import com.carryCompany.carryCompany.order.application.inport.ReadOrderService;
import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.product.application.inport.ReadProductService;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReadOrderFacade {

    private final ReadOrderService readOrderService;

    public List<OrderResponse.MainOrderResponse> readAllOrder() {
        return readOrderService.readAllOrder();

    }
}
