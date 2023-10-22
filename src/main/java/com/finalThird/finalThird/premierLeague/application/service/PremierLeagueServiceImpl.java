package com.finalThird.finalThird.premierLeague.application.service;

import com.finalThird.finalThird.common.exception.ApiException;
import com.finalThird.finalThird.common.exception.ErrorCode;
import com.finalThird.finalThird.common.exception.premierLeagueBoard.TeamNotFoundException;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.application.outport.eplBoardReader;
import com.finalThird.finalThird.premierLeague.application.outport.eplBoardStore;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import com.finalThird.finalThird.premierLeague.application.inport.PremierLeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PremierLeagueServiceImpl implements PremierLeagueService {

  private final eplBoardReader reader;
  private final eplBoardStore store;
  @Override
  public void postEplBoard(EplRequest.BoardRequest request, String teamName, Customer me) {
    //팀이 게시판 활성화 되어있는지 확인
    PremierLeagueTeam team = checkTeamActivate(teamName);
    //저장
    PremierLeagueBoard board = PremierLeagueBoard.create(request, team, me);
    store.saveBoard(board);
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

  @Override
  public void patchEplBoard(Long boardId, EplRequest.BoardPatchRequest request, Customer me) {
    PremierLeagueBoard board = reader.findBoardById(boardId);
    createdUserValidation(me, board);
    //더티체킹
    board.modify(request);
  }

  @Override
  public void postManualTeam(EplRequest.CreateManualTeam request) {
    PremierLeagueTeam team = new PremierLeagueTeam().create(request);
    store.createTeam(team);
  }

  private static void createdUserValidation(Customer me, PremierLeagueBoard board) {
    if(board.getCreateUser().getCustomerEmail().equals(me.getCustomerEmail())){
      throw new ApiException(ErrorCode.INVALID_USER);
    }
  }
}
