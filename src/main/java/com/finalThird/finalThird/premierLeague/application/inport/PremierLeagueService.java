package com.finalThird.finalThird.premierLeague.application.inport;

import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;

public interface PremierLeagueService {


  void postEplBoard(EplRequest.BoardRequest request, String teamName, Customer me);

  PremierLeagueTeam checkTeamActivate(String teamName);

  void patchEplBoard(Long boardId, EplRequest.BoardPatchRequest request, Customer me);

  void postManualTeam(EplRequest.CreateManualTeam request);
}
