package com.carryCompany.carryCompany.order.external.order;

import com.carryCompany.carryCompany.order.application.outport.OrderStore;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.order.external.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderStoreImpl implements OrderStore {

    private final OrderRepository orderRepository;

    @Override
    public void saveMainOrder(MainOrder order) {
        orderRepository.save(order);
    }
}
