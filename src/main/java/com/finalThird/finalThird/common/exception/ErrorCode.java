package com.finalThird.finalThird.common.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {

  /* 400 BAD_REQUEST : 잘못된 요청 */
  MISSING_ORDER_STATUS(
      HttpStatus.BAD_REQUEST,
      "400-001-D",
      "주문 상태 구분 또는 구분 상태 값이 없습니다.\n(둘중 하나는 필수값입니다)"
  ),
  MISSING_ORDER_NUMBER(
      HttpStatus.BAD_REQUEST,
      "400-002-D",
      "주문 상태 구분 또는 구분 상태 값이 없습니다.\n(둘중 하나는 필수값입니다)"
  ),

  BAD_CODE_GROUP(HttpStatus.BAD_REQUEST, "400-003-D", "잘못된 대분류코드 입니다."),

  VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "400-004-D", "잘못된 요청입니다."),

  INVALID_ID_PASSWORD(HttpStatus.BAD_REQUEST, "400-005", "아이디, 비밀번호를 확인해 주십시오."),
  INVALID_ECOUNT_COM_CODE(HttpStatus.BAD_REQUEST, "400-005-D", "올바르지 않은 이카운트 회사 코드입니다."),

  NOT_ALLOWED_EXTENSION(HttpStatus.BAD_REQUEST, "허용되지 않는 확장자입니다."),
  NOT_ALLOWED_MEDIA_TYPES(HttpStatus.BAD_REQUEST, "허용되지 않는 미디어타입입니다."),

  /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
  USER_NOT_FOUND(HttpStatus.UNAUTHORIZED, "존재하지 않는 유저 입니다."),
  BAD_CREDENTIALS(HttpStatus.UNAUTHORIZED, "아이디, 비밀번호를 확인해 주십시오."),
  INVALID_USER(HttpStatus.UNAUTHORIZED, "사용자 로그인 정보가 올바르지 않습니다."),
  CREDENTIALS_EXPIRED(HttpStatus.UNAUTHORIZED, "비밀번호가 만료된 계정입니다."),
  /* 403 FORBIDDEN : 권한이 없는 사용자 */

  /* 404 NOT_FOUND : Resource 를 찾을 수 없음  */
  ATTACHED_FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "첨부파일 정보를 찾을 수 없습니다."),

  /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
  DUPLICATE_ACCOUNT(HttpStatus.CONFLICT, "동일한 코드가 이미 존재합니다."),


  /* 500 Internal Server Error : 내부 서버 에러. 예외처리는 하되, 예외가 생기지 않게 할것. */
  COMMUNICATION_ERROR(
      HttpStatus.INTERNAL_SERVER_ERROR,
      "500-001-D",
      "서버와 통신 처리 중 오류가 발생 하였습니다."),


  /*아래는 디폴트 에러*/
  INSERT_PAGE_GROUP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-019-D", "페이지 그룹 생성 중 오류가 발생 했습니다."),
  UPDATE_PAGE_GROUP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-020-D", "페이지 그룹 수정 중 오류가 발생 했습니다."),
  DELETE_PAGE_GROUP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-021-D", "페이지 그룹 삭제 중 오류가 발생 했습니다."),
  INSERT_PAGE_LIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-022-D", "페이지 생성 중 오류가 발생 했습니다."),
  UPDATE_PAGE_LIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-023-D", "페이지 수정 중 오류가 발생 했습니다."),
  DELETE_PAGE_LIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-024-D", "페이지 삭제 중 오류가 발생 했습니다."),
  INSERT_ADMIN_GROUP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-025-D", "관리자 그룹 생성 중 오류가 발생 했습니다."),
  UPDATE_ADMIN_GROUP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-026-D", "관리자 그룹 수정 중 오류가 발생 했습니다."),
  DELETE_ADMIN_GROUP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-027-D", "관리자 그룹 삭제 중 오류가 발생 했습니다."),
  INSERT_ADMIN_LIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-028-D", "관리자 생성 중 오류가 발생 했습니다."),
  UPDATE_ADMIN_LIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-029-D", "관리자 수정 중 오류가 발생 했습니다."),
  DELETE_ADMIN_LIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-030-D", "관리자 삭제 중 오류가 발생 했습니다."),
  UPDATE_IP_AUTH_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500-031-D", "아이피 인증 처리중 오류가 발생 했습니다."),

  FILE_DOWNLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "파일 다운로드 중 오류가 발생 했습니다."),
  /*아래는 디폴트 에러*/

  /* 400 BAD_REQUEST : 잘못된 요청 */

  /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
  INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "리프레시 토큰이 유효하지 않습니다.\n(다른 PC에서 로그인 되었거나, 토큰이 만료되었습니다.)\n\n다시 로그인해 주세요."),
  MISSING_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "401-001-D", "엑세스 토큰이 없는 요청입니다."),
  INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "401-002-D", "유효하지 않은 엑세스 토큰입니다."),
  EXPIRED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 리프레시 토큰입니다.\n다시 로그인해 주세요."),
  MISSING_TOKEN(HttpStatus.UNAUTHORIZED, "로그인 되지 않았습니다."),
  NOT_LOGIN(HttpStatus.UNAUTHORIZED, "로그인 되지 않았습니다."),

  /* 403 FORBIDDEN : 권한이 없는 사용자 */
  FORBIDDEN_TOKEN(HttpStatus.FORBIDDEN, "요청에 대한 권한이 없습니다."),
  ACCESS_DENIED_EXCEPTION(HttpStatus.FORBIDDEN, "요청이 거부되었습니다."),

  /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
  NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 내용을 찾을 수 없습니다."),

  NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND, "공지를 찾을 수 없습니다."),
  /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
  DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다."),

  /* 500 Internal Server Error : 내부 서버 에러. 예외처리는 하되, 예외가 생기지 않게 할것. */
  COMMON_SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "작업 처리중 오류가 발생했습니다."),
  RUNTIME_EXCEPTION(
      HttpStatus.INTERNAL_SERVER_ERROR,
      "500-101-D",
      "작업 처리중 오류가 발생했습니다."),

  INTERNAL_SERVER_ERROR(
      HttpStatus.INTERNAL_SERVER_ERROR,
      "500-102-D",
      "작업 처리중 오류가 발생했습니다."),

  ILLEGAL_ARGUMENT_EXCEPTION(
      HttpStatus.INTERNAL_SERVER_ERROR,
      "500-103-D",
      "작업 처리중 오류가 발생했습니다."),


  RUNTIME_EXCEPTION_TOKEN(HttpStatus.INTERNAL_SERVER_ERROR, "500-104-D", "유효하지 않은 엑세스 토큰입니다.");


  private final HttpStatus httpStatus;
  private final String message;

  /* 코드 형식 : httpStatus-*** */
  /* 개발자 실수인경우 : httpStatus-***-D : */
  /* 자주 발생하거나 유사한 여러 오류가 있을때 코드를 작성할것 */
  private final String code;

  ErrorCode(HttpStatus httpStatus, String message) {
    this.httpStatus = httpStatus;
    this.message = message;
    this.code = null;
    //code = httpStatus.toString()+"-000";
  }

  ErrorCode(HttpStatus httpStatus, String code, String message) {
    this.httpStatus = httpStatus;
    this.code = code;
    this.message = message;
  }
}