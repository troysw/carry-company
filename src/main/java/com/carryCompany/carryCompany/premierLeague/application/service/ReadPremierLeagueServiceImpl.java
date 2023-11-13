package com.carryCompany.carryCompany.premierLeague.application.service;

import com.carryCompany.carryCompany.premierLeague.controller.dto.EplResponse;
import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueBoard;
import com.carryCompany.carryCompany.premierLeague.external.repository.BoardCommentRepository;
import com.carryCompany.carryCompany.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.carryCompany.carryCompany.premierLeague.external.repository.PremierLeagueTeamRepository;
import com.carryCompany.carryCompany.premierLeague.application.inport.ReadPremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadPremierLeagueServiceImpl implements ReadPremierLeagueService {

  private final PremierLeagueBoardRepository boardRepository;
  private final PremierLeagueTeamRepository teamRepository;
  private final BoardCommentRepository commentRepository;

  public Page<EplResponse.boardListResponse> readEplBoardList(String teamName, Pageable pageable) {
    //최신순으로 조회
    Page<PremierLeagueBoard> pageList = boardRepository.findByTeam_TeamNameOrderByCreatedDateDesc(teamName, pageable);

    return pageList.map(PremierLeagueBoard::toResponse);
  }
}
