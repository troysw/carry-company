package com.carryCompany.carryCompany.product.application.service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ProductResponse {

  @Data
  public static class boardListResponse {
    public Long boardId;
    public String customerNickName;
    public String title;
    public LocalDateTime createdDate;
    public int views;
  }

  @Getter
  @Setter
  public static class ProductCategoryResponse {
    private Long productId;
    private String productName;
    private String productMemo;
  }


}
