package com.carryCompany.carryCompany.order.controller;

import com.carryCompany.carryCompany.common.response.CommonResponse;
import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.facade.ReadOrderFacade;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class ReadOrderController {

    private final ReadOrderFacade readOrderFacade;


    //주문 전체 조회
    @GetMapping("")
    public CommonResponse<List<OrderResponse.MainOrderResponse>> readAllOrder() {
        List<OrderResponse.MainOrderResponse> res = readOrderFacade.readAllOrder();
        return CommonResponse.success(res);
    }

//
//    //제품 전체 조회
//    @GetMapping("/item")
//    public CommonResponse<Page<ProductResponse.ProductItemResponse>> readItemList(Pageable pageable) {
//        var res = readProductFacade.readItemList(pageable);
//        return CommonResponse.success(res);
//    }

    //팀별 게시판 상세 조회


}
