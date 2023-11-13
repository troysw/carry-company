package com.carryCompany.carryCompany.premierLeague.external.eplBoard;

import com.carryCompany.carryCompany.premierLeague.application.outport.eplBoardStore;
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
