package com.carryCompany.carryCompany.premierLeague.application.outport;

import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueBoard;
import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueTeam;

public interface eplBoardReader {
  PremierLeagueTeam findTeam(String teamName);

  PremierLeagueBoard findBoardById(Long boardId);
}
