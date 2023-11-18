package com.carryCompany.carryCompany.product.controller;

import com.carryCompany.carryCompany.common.response.CommonResponse;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import com.carryCompany.carryCompany.product.facade.ReadProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ReadProductController {

    private final ReadProductFacade readProductFacade;


    //카테고리 전체 조회
    @GetMapping("/category")
    public CommonResponse<Page<ProductResponse.ProductCategoryResponse>> readCategoryList(Pageable pageable) {
        var res = readProductFacade.readCategoryList(pageable);
        return CommonResponse.success(res);
    }

    //팀별 게시판 상세 조회


}
