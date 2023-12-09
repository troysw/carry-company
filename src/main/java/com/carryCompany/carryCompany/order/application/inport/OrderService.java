package com.carryCompany.carryCompany.order.application.inport;

import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.order.domain.OrderBundle;
import com.carryCompany.carryCompany.truck.domain.Truck;
import com.carryCompany.carryCompany.vendor.domain.Vendor;

import java.util.List;

public interface OrderService {
    void createMainOrder(List<MainOrderRequest.MainOrderCreateRequest> request, OrderBundle bundle, Vendor vendor, Truck truck);

    OrderBundle createBundleAndSave(String humanCode, Vendor vendor);
}
