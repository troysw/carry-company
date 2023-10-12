package com.finalThird.finalThird.premierLeague.facade;

import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.service.inport.PremierLeagueService;
import com.finalThird.finalThird.premierLeague.service.inport.ReadPremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReadPremierLeagueFacade {

  private final ReadPremierLeagueService readPremierLeagueService;

  public void readEplBoardList(String teamName) {
    readPremierLeagueService.readEplBoardList(teamName);
  }
}
