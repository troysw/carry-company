package com.carryCompany.carryCompany.premierLeague.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

public class EplResponse {

  @Data
  public static class boardListResponse {
    public Long boardId;
    public String customerNickName;
    public String title;
    public LocalDateTime createdDate;
    public int views;
  }

}
