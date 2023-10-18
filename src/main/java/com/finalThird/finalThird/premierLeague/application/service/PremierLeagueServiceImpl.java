package com.finalThird.finalThird.premierLeague.application.service;

import com.finalThird.finalThird.common.exception.premierLeagueBoard.TeamNotFoundException;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.application.outport.eplBoardReader;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import com.finalThird.finalThird.premierLeague.external.repository.BoardCommentRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueTeamRepository;
import com.finalThird.finalThird.premierLeague.application.inport.PremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PremierLeagueServiceImpl implements PremierLeagueService {

  private final PremierLeagueBoardRepository boardRepository;
  private final PremierLeagueTeamRepository teamRepository;
  private final BoardCommentRepository commentRepository;
  private final eplBoardReader reader;
  @Override
  public void postEplBoard(EplRequest.BoardRequest request, String teamName, Customer me) {
    //팀이 게시판에 활성화 되어있는지 확인
    PremierLeagueTeam team = checkTeamActivate(teamName);
    //저장
    PremierLeagueBoard board = PremierLeagueBoard.create(request, team, me);
    boardRepository.save(board);
  }

  @Override
  public PremierLeagueTeam checkTeamActivate(String teamName) {
    PremierLeagueTeam team = reader.findTeam(teamName);
    //epl 비활성화(강등)시 activate = false
    if(!team.isActivate()){
      throw new TeamNotFoundException();
    }
    return team;
  }
}
