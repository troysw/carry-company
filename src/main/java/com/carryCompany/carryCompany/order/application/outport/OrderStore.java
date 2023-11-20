package com.carryCompany.carryCompany.order.application.outport;

import com.carryCompany.carryCompany.order.domain.MainOrder;

public interface OrderStore {
    void saveMainOrder(MainOrder order);
}
