package com.finalThird.finalThird.premierLeague.application.outport;

import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;

import java.util.Optional;

public interface eplBoardReader {
  PremierLeagueTeam findTeam(String teamName);

  PremierLeagueBoard findBoardById(Long boardId);
}
