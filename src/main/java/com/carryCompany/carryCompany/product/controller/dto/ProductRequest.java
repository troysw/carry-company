package com.carryCompany.carryCompany.product.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class ProductRequest {

    @Data
    public static class categoryCreate {
        @NotNull
        private String productName;
        private String productMemo;
    }


    @Data
    public static class categoryUpdate {
        @NotNull
        private Long productId;
        @NotNull
        private String productName;
        private String productMemo;
    }


    @Data
    public static class itemCreate {
        @NotNull
        private Long productId;
        private String itemName;
    }

    @Data
    public static class itemUpdate {
        private Long itemId;
        private String itemName;
        private String itemMemo;
        private Long productId;
        private String productName;
    }


}
