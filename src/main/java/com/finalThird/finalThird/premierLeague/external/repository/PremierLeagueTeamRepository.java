package com.finalThird.finalThird.premierLeague.external.repository;

import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PremierLeagueTeamRepository extends JpaRepository<PremierLeagueTeam, Long> {

  Optional<PremierLeagueTeam> findByTeamName(String teamName);
}
