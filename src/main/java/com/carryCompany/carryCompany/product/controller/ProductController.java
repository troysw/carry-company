package com.carryCompany.carryCompany.product.controller;

import com.carryCompany.carryCompany.common.response.CommonResponse;
import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;
import com.carryCompany.carryCompany.product.facade.ProductFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductFacade productFacade;

    @PostMapping("category")
    @PreAuthorize("hasAnyRole('STAFF')")
    public CommonResponse createCategory(@Valid @RequestBody ProductRequest.categoryCreate request) {
        productFacade.createCategory(request);
        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
    }

    @PatchMapping("category")
    @PreAuthorize("hasAnyRole('STAFF')")
    public CommonResponse updateCategory(@Valid @RequestBody ProductRequest.categoryUpdate request) {
        productFacade.updateCategory(request);
        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
    }

    @DeleteMapping("category/{productId}")
    @PreAuthorize("hasAnyRole('STAFF')")
    public CommonResponse deleteCategory(@PathVariable("productId") Long id) {
        productFacade.deleteCategory(id);
        return CommonResponse.success(null, "성공적으로 삭제 되었습니다.");
    }

    @PostMapping("item")
    @PreAuthorize("hasAnyRole('STAFF')")
    public CommonResponse createItem(@Valid @RequestBody ProductRequest.itemCreate request) {
        productFacade.createItem(request);
        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
    }

    @PatchMapping("item")
    @PreAuthorize("hasAnyRole('STAFF')")
    public CommonResponse updateItem(@Valid @RequestBody ProductRequest.itemUpdate request) {
        productFacade.updateItem(request);
        return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
    }
}
