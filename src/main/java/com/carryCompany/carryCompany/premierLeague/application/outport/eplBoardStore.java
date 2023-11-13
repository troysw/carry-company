package com.carryCompany.carryCompany.premierLeague.application.outport;

import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueBoard;
import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueTeam;

public interface eplBoardStore {
  void saveBoard(PremierLeagueBoard board);

  void createTeam(PremierLeagueTeam premierLeagueTeam);
}
