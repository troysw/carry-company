package com.carryCompany.carryCompany.product.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductState {
  LOADING("상차"),
  DELIVERY("운송중"),
  LANDING("하차"),
  COMPLETE("완료");

  private final String value;

}
