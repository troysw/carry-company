package com.carryCompany.carryCompany.order.external.order;

import com.carryCompany.carryCompany.order.application.outport.OrderStore;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.order.domain.OrderBundle;
import com.carryCompany.carryCompany.order.external.repository.OrderBundleRepository;
import com.carryCompany.carryCompany.order.external.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderStoreImpl implements OrderStore {

    private final OrderRepository orderRepository;
    private final OrderBundleRepository bundleRepository;

    @Override
    public void saveMainOrder(MainOrder order) {
        orderRepository.save(order);
    }

    @Override
    public void saveOrderAll(List<MainOrder> orderList) {
        orderRepository.saveAll(orderList);
    }

    @Override
    public void saveBundle(OrderBundle bundle) {
        bundleRepository.save(bundle);
    }
}
