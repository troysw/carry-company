package com.finalThird.finalThird.premierLeague.application.service;

import com.finalThird.finalThird.premierLeague.controller.dto.EplResponse;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.external.repository.BoardCommentRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueTeamRepository;
import com.finalThird.finalThird.premierLeague.application.inport.ReadPremierLeagueService;
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
