package com.carryCompany.carryCompany.common.exception;


import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.io.Serializable;

/**
 * BaseException 또는 BaseException 을 확장한 Exception 은 서비스 운영에서 예상이 가능한 Exception 을 표현한다.
 * <p>
 * 그렇기 때문에 http status: 200 이면서 result: FAIL 을 표현하고 특정 ErrorCode 만 alert 를 포함한 모니터링 대상으로 한다.
 */
@Getter
public class AuthException extends ApiException {



  public AuthException(ErrorCode errorCode) {
    super(errorCode);
  }

  public AuthException(ErrorCode errorCode, ImmutableMap<String, ? extends Serializable> valuesMap) {
    super(errorCode, valuesMap);
  }
/*
  public AuthException(String message, ErrorCode errorCode, Throwable cause) {
    super(message, errorCode, cause);
  }*/
}
