package com.carryCompany.carryCompany.truck.controller;

import com.carryCompany.carryCompany.common.response.CommonResponse;
import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.facade.ReadOrderFacade;
import com.carryCompany.carryCompany.truck.application.service.dto.TruckResponse;
import com.carryCompany.carryCompany.truck.facade.ReadTruckFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/truck")
public class ReadTruckController {
    private final ReadTruckFacade readTruckFacade;


    //주문 전체 조회
    @GetMapping("")
    public CommonResponse<List<TruckResponse.MainTruck>> readAllTruck() {
        List<TruckResponse.MainTruck> res = readTruckFacade.readAllTruck();
        return CommonResponse.success(res);
    }
}
