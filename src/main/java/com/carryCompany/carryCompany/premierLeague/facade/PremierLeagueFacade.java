package com.carryCompany.carryCompany.premierLeague.facade;

import com.carryCompany.carryCompany.common.security.Security;
import com.carryCompany.carryCompany.customer.domain.Customer;
import com.carryCompany.carryCompany.customer.service.CustomerService;
import com.carryCompany.carryCompany.premierLeague.controller.dto.EplRequest;
import com.carryCompany.carryCompany.premierLeague.application.inport.PremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PremierLeagueFacade {

  private final PremierLeagueService leagueService;
  private final CustomerService customerService;
  private final Security security;

  public void postEplBoard(String teamName, EplRequest.BoardRequest request) {
    Customer me = security.getMe();
    leagueService.postEplBoard(request, teamName, me);
  }

  public void updateEplBoard(Long boardId, EplRequest.BoardPatchRequest request) {
    Customer me = security.getMe();
    leagueService.patchEplBoard(boardId ,request, me);
  }

  public void createManualTeam(EplRequest.CreateManualTeam request) {
    leagueService.postManualTeam(request);
  }
}
