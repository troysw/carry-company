package com.carryCompany.carryCompany.premierLeague.facade;

import com.carryCompany.carryCompany.premierLeague.controller.dto.EplResponse;
import com.carryCompany.carryCompany.premierLeague.application.inport.ReadPremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReadPremierLeagueFacade {

  private final ReadPremierLeagueService readPremierLeagueService;

  public Page<EplResponse.boardListResponse> readEplBoardList(String teamName, Pageable pageable) {
    return readPremierLeagueService.readEplBoardList(teamName, pageable);
  }
}
