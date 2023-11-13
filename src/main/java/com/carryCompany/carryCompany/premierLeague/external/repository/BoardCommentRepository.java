package com.carryCompany.carryCompany.premierLeague.external.repository;

import com.carryCompany.carryCompany.premierLeague.domain.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {

}
