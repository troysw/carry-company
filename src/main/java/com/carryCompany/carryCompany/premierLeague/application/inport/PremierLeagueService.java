package com.carryCompany.carryCompany.premierLeague.application.inport;

import com.carryCompany.carryCompany.customer.domain.Customer;
import com.carryCompany.carryCompany.premierLeague.controller.dto.EplRequest;
import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueTeam;

public interface PremierLeagueService {


  void postEplBoard(EplRequest.BoardRequest request, String teamName, Customer me);

  PremierLeagueTeam checkTeamActivate(String teamName);

  void patchEplBoard(Long boardId, EplRequest.BoardPatchRequest request, Customer me);

  void postManualTeam(EplRequest.CreateManualTeam request);
}
