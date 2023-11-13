package com.carryCompany.carryCompany.common.exception.customer;

import com.carryCompany.carryCompany.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class CustomerAlreadyExistException extends ApiException {

  public CustomerAlreadyExistException() {
    super(HttpStatus.NOT_FOUND, "NOTICE_ALREADY_EXIST", "이미 가입 되어 있는 유저 입니다.");
  }

}
