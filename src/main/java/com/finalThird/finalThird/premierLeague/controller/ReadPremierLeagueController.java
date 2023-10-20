package com.finalThird.finalThird.premierLeague.controller;

import com.finalThird.finalThird.common.response.CommonResponse;
import com.finalThird.finalThird.premierLeague.facade.ReadPremierLeagueFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/epl")
public class ReadPremierLeagueController {

  private final ReadPremierLeagueFacade readPremierLeagueFacade;


  //팀별 게시판 리스트 조회
  @GetMapping("{teamName}")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public CommonResponse readEplBoardList(@PathVariable("teamName") String teamName, Pageable pageable) {
    var res = readPremierLeagueFacade.readEplBoardList(teamName, pageable);
    return CommonResponse.success(res);
  }

  //팀별 게시판 상세 조회


}
