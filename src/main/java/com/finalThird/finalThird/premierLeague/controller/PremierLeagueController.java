package com.finalThird.finalThird.premierLeague.controller;

import com.finalThird.finalThird.common.response.CommonResponse;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.facade.PremierLeagueFacade;
import com.finalThird.finalThird.premierLeague.facade.ReadPremierLeagueFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/epl")
public class PremierLeagueController {

  private final PremierLeagueFacade premierLeagueFacade;

  @PostMapping
  public CommonResponse readEplBoardList(@Valid @RequestBody EplRequest.BoardRequest request) {
    premierLeagueFacade.postEplBoard(request);
    return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
  }

}
