package com.carryCompany.carryCompany.premierLeague.external.eplBoard;

import com.carryCompany.carryCompany.common.exception.premierLeagueBoard.BoardNotFoundException;
import com.carryCompany.carryCompany.common.exception.premierLeagueBoard.TeamNotFoundException;
import com.carryCompany.carryCompany.premierLeague.application.outport.eplBoardReader;
import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueBoard;
import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueTeam;
import com.carryCompany.carryCompany.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.carryCompany.carryCompany.premierLeague.external.repository.PremierLeagueTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class eplBoardReaderImpl implements eplBoardReader {

  private final PremierLeagueBoardRepository boardRepository;
  private final PremierLeagueTeamRepository teamRepository;

  @Override
  public PremierLeagueTeam findTeam(String teamName) {
    return teamRepository.findByTeamName(teamName).orElseThrow(TeamNotFoundException::new);
  }

  @Override
  public PremierLeagueBoard findBoardById(Long boardId) {
    return boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new);
  }

}
