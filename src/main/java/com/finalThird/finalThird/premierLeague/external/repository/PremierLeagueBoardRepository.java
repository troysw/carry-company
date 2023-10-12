package com.finalThird.finalThird.premierLeague.external.repository;

import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremierLeagueBoardRepository extends JpaRepository<PremierLeagueBoard, Long> {

  void findByTeam_TeamName(String teamName);
}
