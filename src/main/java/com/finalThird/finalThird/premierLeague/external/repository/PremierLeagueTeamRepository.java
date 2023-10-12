package com.finalThird.finalThird.premierLeague.external.repository;

import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremierLeagueTeamRepository extends JpaRepository<PremierLeagueTeam, Long> {

}
