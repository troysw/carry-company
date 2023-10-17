package com.finalThird.finalThird.premierLeague.service.inport;

import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;

public interface PremierLeagueService {


  void postEplBoard(EplRequest.BoardRequest request, PremierLeagueTeam team, Customer me);

  PremierLeagueTeam checkTeamActivate(String teamName);
}
