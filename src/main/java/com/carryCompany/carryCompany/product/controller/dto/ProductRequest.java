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

}
