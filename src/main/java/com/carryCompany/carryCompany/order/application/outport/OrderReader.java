package com.carryCompany.carryCompany.order.application.outport;

import com.carryCompany.carryCompany.order.domain.MainOrder;

import java.util.List;

public interface OrderReader {
    List<MainOrder> findAllOrder();
}
