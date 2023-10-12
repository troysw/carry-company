package com.finalThird.finalThird.premierLeague.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
@NoArgsConstructor
public class PremierLeagueTeam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long teamId;

  @NotNull
  private String teamName;

  @NotNull
  private Long teamRank;

}
