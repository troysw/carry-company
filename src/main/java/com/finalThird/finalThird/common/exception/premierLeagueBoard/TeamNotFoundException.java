package com.finalThird.finalThird.common.exception.premierLeagueBoard;

import com.finalThird.finalThird.common.exception.ApiException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TeamNotFoundException extends ApiException {

  public TeamNotFoundException() {
    super(HttpStatus.NOT_FOUND, "TEAM_NOT_FOUND", "해당 팀을 찾을 수 없습니다.");
  }

}