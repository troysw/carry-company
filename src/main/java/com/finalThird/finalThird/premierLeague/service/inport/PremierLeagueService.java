package com.finalThird.finalThird.premierLeague.service.inport;

import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import com.finalThird.finalThird.premierLeague.domain.PremierLeagueBoard;

public interface PremierLeagueService {


  void postEplBoard(EplRequest.BoardRequest request, Customer me);
}
