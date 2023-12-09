package com.carryCompany.carryCompany.order.application.outport;

import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.order.domain.OrderBundle;

import java.util.List;

public interface OrderStore {
    void saveMainOrder(MainOrder order);

    void saveOrderAll(List<MainOrder> orderList);

    void saveBundle(OrderBundle bundle);
}
