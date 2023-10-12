package com.finalThird.finalThird.common.exception.customer;

import com.finalThird.finalThird.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class CustomerNotFoundException extends ApiException {

  public CustomerNotFoundException() {
    super(HttpStatus.NOT_FOUND, "CUSTOMER_NOT_FOUND", "해당 유저를 찾을 수 없습니다.");
  }

}
