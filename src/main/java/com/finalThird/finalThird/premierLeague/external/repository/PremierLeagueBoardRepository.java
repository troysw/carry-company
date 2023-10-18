package com.finalThird.finalThird.premierLeague.external.repository;

import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremierLeagueBoardRepository extends JpaRepository<PremierLeagueBoard, Long> {

  Page<PremierLeagueBoard> findByTeam_TeamNameOrderByCreatedDateDesc(String teamName, Pageable pageable);
}
