package com.carryCompany.carryCompany.premierLeague.external.repository;

import com.carryCompany.carryCompany.premierLeague.domain.PremierLeagueTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PremierLeagueTeamRepository extends JpaRepository<PremierLeagueTeam, Long> {

  Optional<PremierLeagueTeam> findByTeamName(String teamName);
}
