package com.carryCompany.carryCompany.product;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import jakarta.persistence.*;
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

  private String productName;

  @OrderBy("createdDate desc")
  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private List<ProductItem> itemList = new ArrayList<>();
}
