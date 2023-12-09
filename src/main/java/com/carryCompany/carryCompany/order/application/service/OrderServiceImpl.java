package com.carryCompany.carryCompany.order.application.service;

import com.carryCompany.carryCompany.order.application.inport.OrderService;
import com.carryCompany.carryCompany.order.application.outport.OrderReader;
import com.carryCompany.carryCompany.order.application.outport.OrderStore;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.order.domain.OrderBundle;
import com.carryCompany.carryCompany.order.domain.OrderTruck;
import com.carryCompany.carryCompany.truck.domain.Truck;
import com.carryCompany.carryCompany.vendor.domain.Vendor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderReader orderReader;
    private final OrderStore orderStore;


    @Override
    public void createMainOrder(List<MainOrderRequest.MainOrderCreateRequest> request, OrderBundle bundle, Vendor vendor, Truck truck) {

        List<MainOrder> list = request.stream().map(req -> MainOrder.create(req, bundle, vendor)).toList();

        List<OrderTruck> list1 = list.stream().map(order -> OrderTruck.create(order, truck)).toList();
        orderStore.saveOrderAll(list);

    }
    @Override
    public OrderBundle createBundleAndSave(String humanCode, Vendor vendorName) {
        OrderBundle bundle = OrderBundle.create(humanCode, vendorName);
        orderStore.saveBundle(bundle);
        return bundle;
    }
}
