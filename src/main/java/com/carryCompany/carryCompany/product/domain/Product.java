package com.carryCompany.carryCompany.product.domain;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class Product extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long productId;

  @Size(max = 300)
  private String productName;

  @Size(max = 1000)
  private String productMemo;

  @OrderBy("createdDate desc")
  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private List<ProductItem> itemList = new ArrayList<>();

  public static Product create(ProductRequest.categoryCreate request) {
    Product res = new Product();
    res.setProductName(request.getProductName());
    res.setProductMemo(request.getProductMemo());
    return res;
  }

  public void update(ProductRequest.categoryUpdate request) {
    this.setProductName(request.getProductName());
    this.setProductMemo(request.getProductMemo());
  }

  public ProductResponse.ProductCategoryResponse toResponse() {
    ProductResponse.ProductCategoryResponse res = new ProductResponse.ProductCategoryResponse();
    res.setProductId(this.productId);
    res.setProductName(this.productName);
    res.setProductMemo(this.productMemo);
    return res;
  }
}
