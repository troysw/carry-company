package com.carryCompany.carryCompany.premierLeague.controller;

import com.carryCompany.carryCompany.common.response.CommonResponse;
import com.carryCompany.carryCompany.premierLeague.controller.dto.EplRequest;
import com.carryCompany.carryCompany.premierLeague.facade.PremierLeagueFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/epl")
public class PremierLeagueController {

  private final PremierLeagueFacade facade;

  @PostMapping("make-team-manual")
//todo  @PreAuthorize("hasAnyRole('ADMIN')") 추후 도입
  public CommonResponse postEplTeamManual(@Valid @RequestBody EplRequest.CreateManualTeam request){
    facade.createManualTeam(request);
    return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
  }

  @PostMapping("{teamName}")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public CommonResponse postEplBoardList(@PathVariable("teamName")String teamName,
                                         @Valid @RequestBody EplRequest.BoardRequest request) {
    facade.postEplBoard(teamName, request);
    return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
  }

  @PatchMapping("{boardId}")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public CommonResponse updateEplBoardList(@PathVariable("boardId")Long boardId,
                                         @Valid @RequestBody EplRequest.BoardPatchRequest request) {
    facade.updateEplBoard(boardId, request);
    return CommonResponse.success(null, "성공적으로 저장 되었습니다.");
  }

}
