package com.finalThird.finalThird.premierLeague.external.eplBoard;

import com.finalThird.finalThird.premierLeague.application.outport.eplBoardStore;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueBoardRepository;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class eplBoardStoreImpl implements eplBoardStore {

  private final PremierLeagueBoardRepository boardRepository;
  private final PremierLeagueTeamRepository teamRepository;


  @Override
  public void saveBoard(PremierLeagueBoard board) {
    boardRepository.save(board);
  }

  @Override
  public void createTeam(PremierLeagueTeam premierLeagueTeam) {
    teamRepository.save(premierLeagueTeam);
  }

}
