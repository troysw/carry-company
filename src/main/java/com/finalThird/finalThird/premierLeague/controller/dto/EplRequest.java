package com.finalThird.finalThird.premierLeague.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

public class EplRequest {

  @Data
  public static class BoardRequest {
    public String customerEmail;
    public String title;
    public String content;
  }
}
