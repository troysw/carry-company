package com.carryCompany.carryCompany.common.exception.premierLeagueBoard;

import com.carryCompany.carryCompany.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BoardNotFoundException extends ApiException {

  public BoardNotFoundException() {
    super(HttpStatus.NOT_FOUND, "BOARD_NOT_FOUND", "해당 게시글을 찾을 수 없습니다.");
  }

}