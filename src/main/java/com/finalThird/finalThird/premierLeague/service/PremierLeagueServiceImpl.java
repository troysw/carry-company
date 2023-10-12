package com.finalThird.finalThird.premierLeague.service;

import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
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
  public void postEplBoard(EplRequest.BoardRequest request, Customer me) {
    PremierLeagueBoard board = PremierLeagueBoard.create(request, me);
    boardRepository.save(board);
  }
}
