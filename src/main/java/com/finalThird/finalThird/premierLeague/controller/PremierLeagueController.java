package com.finalThird.finalThird.premierLeague.controller;

import com.finalThird.finalThird.common.response.CommonResponse;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.facade.PremierLeagueFacade;
import com.finalThird.finalThird.premierLeague.facade.ReadPremierLeagueFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/epl")
public class PremierLeagueController {

  private final PremierLeagueFacade premierLeagueFacade;

  @PostMapping({"teamName"})
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public CommonResponse postEplBoardList(@PathVariable("teamName")String teamName,
                                         @Valid @RequestBody EplRequest.BoardRequest request) {
    premierLeagueFacade.postEplBoard(teamName, request);
    return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
  }

  @PatchMapping({"boardId"})
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public CommonResponse updateEplBoardList(@PathVariable("boardId")Long boardId,
                                         @Valid @RequestBody EplRequest.BoardPatchRequest request) {
    premierLeagueFacade.updateEplBoard(boardId, request);
    return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
  }

}
