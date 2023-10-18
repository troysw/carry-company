package com.finalThird.finalThird.premierLeague.application.inport;

import com.finalThird.finalThird.premierLeague.controller.dto.EplResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadPremierLeagueService {
  Page<EplResponse.boardListResponse> readEplBoardList(String teamName, Pageable pageable);
}
