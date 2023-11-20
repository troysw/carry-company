package com.carryCompany.carryCompany.order.controller;

import com.carryCompany.carryCompany.common.response.CommonResponse;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.order.facade.OrderFacade;
import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class orderController {

    private final OrderFacade orderFacade;

    @PostMapping("insert")
    @PreAuthorize("hasAnyRole('STAFF')")
    public CommonResponse createMainOrder(@RequestBody List<MainOrderRequest.MainOrderCreateRequest> request) {
        orderFacade.createMainOrder(request);
        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
    }
//
//    @PatchMapping("category")
//    @PreAuthorize("hasAnyRole('STAFF')")
//    public CommonResponse updateCategory(@Valid @RequestBody ProductRequest.categoryUpdate request) {
//        productFacade.updateCategory(request);
//        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
//    }
//
//    @DeleteMapping("category/{productId}")
//    @PreAuthorize("hasAnyRole('STAFF')")
//    public CommonResponse deleteCategory(@PathVariable("productId") Long id) {
//        productFacade.deleteCategory(id);
//        return CommonResponse.success(null, "성공적으로 삭제 되었습니다.");
//    }
//
//    @PostMapping("item")
//    @PreAuthorize("hasAnyRole('STAFF')")
//    public CommonResponse createItem(@Valid @RequestBody ProductRequest.itemCreate request) {
//        productFacade.createItem(request);
//        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
//    }
//
//    @PatchMapping("item")
//    @PreAuthorize("hasAnyRole('STAFF')")
//    public CommonResponse updateItem(@Valid @RequestBody ProductRequest.itemUpdate request) {
//        productFacade.updateItem(request);
//        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
//    }
}
