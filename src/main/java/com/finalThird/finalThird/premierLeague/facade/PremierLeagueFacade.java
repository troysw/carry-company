package com.finalThird.finalThird.premierLeague.facade;

import com.finalThird.finalThird.common.security.Security;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.customer.service.CustomerService;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import com.finalThird.finalThird.premierLeague.service.inport.PremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PremierLeagueFacade {

  private final PremierLeagueService premierLeagueService;
  private final CustomerService customerService;
  private final Security security;

  public void postEplBoard(String teamName, EplRequest.BoardRequest request) {
    PremierLeagueTeam team = premierLeagueService.checkTeamActivate(teamName);
    Customer me = security.getMe();
    premierLeagueService.postEplBoard(request,team, me);
  }
}
