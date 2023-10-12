package com.finalThird.finalThird.common.response;

import com.finalThird.finalThird.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

  //성공여부
  private Result result;
  //응답데이터
  private T data;
  //메세지
  private String message;
  //오류 코드
  private String errorCode;

  public static <T> CommonResponse<T> success(T data, String message) {
    return (CommonResponse<T>) CommonResponse.builder()
        .result(Result.SUCCESS)
        .data(data)
        .message(message)
        .build();
  }

  public static <T> CommonResponse<T> success(T data) {
    return success(data, null);
  }

  public static CommonResponse success(String message) {
    return success(null, message);
  }

  public static <T> CommonResponse<T> fail(T data, String message, String errorCode) {
    return (CommonResponse<T>) CommonResponse.builder()
        .result(Result.FAIL)
        .data(data)
        .message(message)
        .errorCode(errorCode)
        .build();
  }

  public static CommonResponse fail(String message, String errorCode) {
    return CommonResponse.builder()
        .result(Result.FAIL)
        .message(message)
        .errorCode(errorCode)
        .build();
  }

  public static CommonResponse fail(ErrorCode errorCode) {
    return CommonResponse.builder()
        .result(Result.FAIL)
        .message(errorCode.getMessage())
        .errorCode(errorCode.name())
        .build();
  }

  public static CommonResponse fail(String message) {
    return CommonResponse.builder()
        .result(Result.FAIL)
        .message(message)
        .errorCode(null)
        .build();
  }

  public enum Result {
    SUCCESS, FAIL
  }
}
