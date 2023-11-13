package com.carryCompany.carryCompany.common.exception;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
public class ApiException extends RuntimeException {

  private final HttpStatus httpStatus;
  private final String name;
  private final String message;
  private String code;
  private ImmutableMap<String, ? extends Serializable> valuesMap;

  public ApiException(HttpStatus httpStatus, String name, String message, String code) {
    super(message);
    this.httpStatus = httpStatus;
    this.name = name;
    this.message = message;
    this.code = code;
  }

  public ApiException(HttpStatus httpStatus, String name, String message) {
    super(message);
    this.httpStatus = httpStatus;
    this.name = name;
    this.message = message;
  }

  public ApiException(ErrorCode e) {
    super(e.getMessage());
    this.httpStatus = e.getHttpStatus();
    this.name = e.name();
    this.message = e.getMessage();
    this.code = e.getCode();
  }

  public ApiException(ErrorCode e, ImmutableMap<String, ? extends Serializable> valuesMap) {
    super(e.getMessage());
    this.httpStatus = e.getHttpStatus();
    this.name = e.name();
    this.message = e.getMessage();
    this.code = e.getCode();
    this.valuesMap = valuesMap;
  }

  public ApiException(ErrorCode e, Throwable cause) {
    super(e.getMessage(), cause);
    this.httpStatus = e.getHttpStatus();
    this.name = e.name();
    this.message = e.getMessage();
    this.code = e.getCode();
  }

  public ApiException(ErrorCode e, Throwable cause, ImmutableMap<String, ? extends Serializable> valuesMap) {
    super(e.getMessage(), cause);
    this.httpStatus = e.getHttpStatus();
    this.name = e.name();
    this.message = e.getMessage();
    this.code = e.getCode();
    this.valuesMap = valuesMap;
  }
}