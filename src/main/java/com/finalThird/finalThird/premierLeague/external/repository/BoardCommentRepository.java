package com.finalThird.finalThird.premierLeague.external.repository;

import com.finalThird.finalThird.premierLeague.domain.BoardComment;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {

}
