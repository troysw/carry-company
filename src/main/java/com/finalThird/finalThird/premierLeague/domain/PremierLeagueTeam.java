package com.finalThird.finalThird.premierLeague.domain;

import com.finalThird.finalThird.common.entity.BaseEntity;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
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
public class PremierLeagueTeam extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long teamId;

  @NotNull
  @Column(name="teamName" , unique=true)
  private String teamName;

  @NotNull
  private int teamRank;

  private boolean activate;

  public PremierLeagueTeam create(EplRequest.CreateManualTeam request) {
    PremierLeagueTeam res = new PremierLeagueTeam();
    res.setTeamName(request.getTeamName());
    res.setActivate(true);
    res.setTeamRank(request.getTeamRank());
    return res;
  }
}
