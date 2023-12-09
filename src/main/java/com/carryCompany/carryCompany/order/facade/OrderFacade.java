package com.carryCompany.carryCompany.order.facade;

import com.carryCompany.carryCompany.order.application.inport.OrderService;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.order.domain.OrderBundle;
import com.carryCompany.carryCompany.order.domain.OrderTruck;
import com.carryCompany.carryCompany.truck.application.inport.ReadTruckService;
import com.carryCompany.carryCompany.truck.application.inport.TruckService;
import com.carryCompany.carryCompany.truck.domain.Truck;
import com.carryCompany.carryCompany.vendor.application.inport.VendorService;
import com.carryCompany.carryCompany.vendor.domain.Vendor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OrderFacade {

    private final OrderService orderService;
    private final VendorService vendorService;
    private final ReadTruckService readTruckService;
    public void createMainOrder(Map<String, List<MainOrderRequest.MainOrderCreateRequest>> request) {
        String humanCode = "";
        String vendorName = "";
        String truckBackNumber = "";
        // Map의 모든 엔트리에 대해 반복합니다.
        for (Map.Entry<String, List<MainOrderRequest.MainOrderCreateRequest>> entry : request.entrySet()) {
            String key = entry.getKey();  // 엔트리의 키를 가져옵니다.
            List<MainOrderRequest.MainOrderCreateRequest> value = entry.getValue();  // 엔트리의 값을 가져옵니다.

            humanCode = value.get(0).getHumanCode();
            vendorName = value.get(0).getVendorName();
            truckBackNumber = value.get(0).getTruckBackNumber();

            Truck truck = readTruckService.readTruckByBackNumber(truckBackNumber);
            Vendor vendor = vendorService.findVendorByName(vendorName);
            OrderBundle bundle = orderService.createBundleAndSave(humanCode, vendor);

            orderService.createMainOrder(value,bundle,vendor,truck);

            for (MainOrderRequest.MainOrderCreateRequest order : value) {
                order.getHumanCode();
            }
        }
    }
}
