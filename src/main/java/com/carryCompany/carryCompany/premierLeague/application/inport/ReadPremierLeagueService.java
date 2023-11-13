package com.carryCompany.carryCompany.premierLeague.application.inport;

import com.carryCompany.carryCompany.premierLeague.controller.dto.EplResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadPremierLeagueService {
  Page<EplResponse.boardListResponse> readEplBoardList(String teamName, Pageable pageable);
}
