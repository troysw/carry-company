package com.finalThird.finalThird.premierLeague.service;

import com.finalThird.finalThird.common.exception.premierLeagueBoard.TeamNotFoundException;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import com.finalThird.finalThird.premierLeague.external.repository.BoardCommentRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueTeamRepository;
import com.finalThird.finalThird.premierLeague.service.inport.PremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PremierLeagueServiceImpl implements PremierLeagueService {

  private final PremierLeagueBoardRepository boardRepository;
  private final PremierLeagueTeamRepository teamRepository;
  private final BoardCommentRepository commentRepository;
  @Override
  public void postEplBoard(EplRequest.BoardRequest request,PremierLeagueTeam team, Customer me) {
    PremierLeagueBoard board = PremierLeagueBoard.create(request, team, me);
    boardRepository.save(board);
  }

  @Override
  public PremierLeagueTeam checkTeamActivate(String teamName) {
    PremierLeagueTeam team = teamRepository.findByTeamName(teamName).orElseThrow(TeamNotFoundException::new);
    //epl 비활성화(강등)시
    if(!team.isActivate()){
      throw new TeamNotFoundException();
    }
    return team;
  }
}
