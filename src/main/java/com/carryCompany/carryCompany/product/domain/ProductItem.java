package com.carryCompany.carryCompany.product.domain;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.product.application.service.dto.ProductResponse;
import com.carryCompany.carryCompany.product.controller.dto.ProductRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class ProductItem extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long itemId;

  private String productItemName;

  private String itemRes;

  private String itemMemo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk__product__productItem"))
  private Product product;

  public static ProductItem create(ProductRequest.itemCreate request, Product product) {
    ProductItem item = new ProductItem();
    item.setProductItemName(request.getItemName());
    item.setProduct(product);
    return item;
  }

  public ProductResponse.ProductItemResponse toResponse() {
    ProductResponse.ProductItemResponse response = new ProductResponse.ProductItemResponse();
    response.setProductId(this.product.getProductId());
    response.setItemId(this.itemId);
    response.setProductName(this.product.getProductName());
    response.setItemName(this.getProductItemName());
    return response;
  }

    public void update(ProductRequest.itemUpdate request, Product product) {
      this.setProduct(product);
      this.setProductItemName(request.getItemName());
    }
}
