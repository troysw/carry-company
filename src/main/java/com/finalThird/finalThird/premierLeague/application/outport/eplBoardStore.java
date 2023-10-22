package com.finalThird.finalThird.premierLeague.application.outport;

import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;

public interface eplBoardStore {
  void saveBoard(PremierLeagueBoard board);

  void createTeam(PremierLeagueTeam premierLeagueTeam);
}
