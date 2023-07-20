package com.comall.common.response;

import com.comall.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
  private Result result;
  private T data;
  private String message;
  private String errorCode;

  public static <T> CommonResponse<T> success(T data, String message) {
    return (CommonResponse<T>) CommonResponse.builder()
        .result(Result.SUCCESS)
        .data(data)
        .message(message)
        .build();
  }

  //메세지 없이 전송
  public static <T> CommonResponse<T> success(T data) {
    return success(data, null);
  }

  //데이터없이 ok 처리시 메세지만 전송 ( ex: update,create )
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
        .message(errorCode.getErrorMsg())
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


