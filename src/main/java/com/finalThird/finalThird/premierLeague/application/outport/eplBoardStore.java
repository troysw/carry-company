package com.finalThird.finalThird.premierLeague.application.outport;

import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;

public interface eplBoardStore {
  void saveBoard(PremierLeagueBoard board);
}
