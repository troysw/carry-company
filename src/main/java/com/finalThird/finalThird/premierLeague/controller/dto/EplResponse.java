package com.finalThird.finalThird.premierLeague.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

public class EplResponse {

  @Data
  public static class boardListResponse {
    public Long boardId;
    public String customerName;
    public String title;
    public LocalDateTime createdDate;
    public Long views;
  }

}
