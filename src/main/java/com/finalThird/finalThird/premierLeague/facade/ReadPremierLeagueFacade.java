package com.finalThird.finalThird.premierLeague.facade;

import com.finalThird.finalThird.premierLeague.controller.dto.EplResponse;
import com.finalThird.finalThird.premierLeague.application.inport.ReadPremierLeagueService;
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
