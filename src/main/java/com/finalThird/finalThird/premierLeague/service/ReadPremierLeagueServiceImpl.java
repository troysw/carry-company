package com.finalThird.finalThird.premierLeague.service;

import com.finalThird.finalThird.premierLeague.external.repository.BoardCommentRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueTeamRepository;
import com.finalThird.finalThird.premierLeague.service.inport.ReadPremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadPremierLeagueServiceImpl implements ReadPremierLeagueService {

  private final PremierLeagueBoardRepository boardRepository;
  private final PremierLeagueTeamRepository teamRepository;
  private final BoardCommentRepository commentRepository;

  public void readEplBoardList(String teamName) {
    boardRepository.findByTeam_TeamName(teamName);
  }
}
