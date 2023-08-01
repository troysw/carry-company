package com.comall.comall.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  FORBIDDEN_ERROR("접근할 수 없습니다.");
  private final String errorMsg;
  public String getErrorMsg(Object... arg) {
    return String.format(errorMsg, arg);
  }
}
