package com.finalThird.finalThird.premierLeague.controller;

import com.finalThird.finalThird.common.response.CommonResponse;
import com.finalThird.finalThird.premierLeague.facade.ReadPremierLeagueFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/epl")
public class ReadPremierLeagueController {

  private final ReadPremierLeagueFacade readPremierLeagueFacade;

  @GetMapping("{teamName}")
  public CommonResponse readEplBoardList(@PathVariable("teamName") String teamName) {
    readPremierLeagueFacade.readEplBoardList(teamName);
    return CommonResponse.success(null);
  }

}
