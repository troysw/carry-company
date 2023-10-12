package com.finalThird.finalThird.common.response;


import com.finalThird.finalThird.common.exception.ApiException;
import com.finalThird.finalThird.common.intercepter.interceptor.CommonHttpRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.commons.text.StringSubstitutor;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(value = ApiException.class)
  public CommonResponse onBaseException(ApiException e) {
    String eventId = MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
    log.warn("[BaseException] eventId = {}, cause = {}, errorMsg = {}", eventId,
        NestedExceptionUtils.getMostSpecificCause(e),
        NestedExceptionUtils.getMostSpecificCause(e).getMessage());
    String message = e.getMessage();
    if (e.getValuesMap() != null) {
      message = StringSubstitutor.replace(message, e.getValuesMap());
    }
    return CommonResponse.fail(message, e.getName());
  }
}