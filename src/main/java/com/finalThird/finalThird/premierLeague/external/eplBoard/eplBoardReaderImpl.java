package com.finalThird.finalThird.premierLeague.external.eplBoard;

import com.finalThird.finalThird.common.exception.premierLeagueBoard.TeamNotFoundException;
import com.finalThird.finalThird.premierLeague.application.outport.eplBoardReader;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;


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
}
