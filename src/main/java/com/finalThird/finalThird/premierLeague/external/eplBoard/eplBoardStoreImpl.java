package com.finalThird.finalThird.premierLeague.external.eplBoard;

import com.finalThird.finalThird.premierLeague.application.outport.eplBoardStore;
import com.finalThird.finalThird.premierLeague.external.repository.PremierLeagueBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class eplBoardStoreImpl implements eplBoardStore {

  private final PremierLeagueBoardRepository boardRepository;


}
