package com.finalThird.finalThird.premierLeague.domain;

import com.finalThird.finalThird.customer.domain.Customer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class BoardComment {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long commentId;

  private String comment;

  private Long commentRank;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id", foreignKey = @ForeignKey(name = "fk__boardComment__board"))
  private PremierLeagueBoard board;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk__boardComment__customer"))
  private Customer createUser;

//  public static BoardComment create(BoardCommand.BoardPostComment request, User me, Board board) {
//    BoardComment res = new BoardComment();
//    res.setComment(request.getComment());
//    res.setBoard(board);
//    res.setCreateUser(me);
//    return res;
//  }
//
//  public void editComment(BoardCommand.BoardEditComment command){
//    this.comment = command.getComment();
//  }

}
