package com.finalThird.finalThird.premierLeague.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class EplRequest {

  @Data
  public static class BoardRequest {
    @NotNull
    public String teamName;
    @NotNull
    public String customerEmail;
    @NotNull
    public String title;
    @NotNull
    public String content;
  }

  @Data
  public static class CreateManualTeam {
    @NotNull
    public String teamName;
    @NotNull
    public String customerEmail;
    @NotNull
    public int teamRank;
  }

  @Data
  public static class BoardPatchRequest {
    @NotNull
    public String teamName;
    @NotNull
    public String customerEmail;
    @NotNull
    public String title;
    @NotNull
    public String content;
  }
}
