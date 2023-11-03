package com.finalThird.finalThird.customer.controller;

import com.finalThird.finalThird.common.response.CommonResponse;
import com.finalThird.finalThird.customer.controller.dto.CustomerResponse;
import com.finalThird.finalThird.customer.service.CustomerService;
import com.finalThird.finalThird.customer.controller.dto.CustomerRequest;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.premierLeague.controller.dto.EplRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("/signup")
  public ResponseEntity<CustomerResponse.JoinResponse> signup(@Valid @RequestBody CustomerRequest.JoinRequest userDto) {
    return ResponseEntity.ok(customerService.signup(userDto));
  }

  @GetMapping("/user")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public ResponseEntity<Customer> getMyUserInfo() {
    return ResponseEntity.ok(customerService.getMyUserWithAuthorities().get());
  }

  @GetMapping("/user/{username}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<CustomerResponse.JoinResponse> getUserInfo(@PathVariable String username) {
    return ResponseEntity.ok(customerService.getUserWithAuthorities(username));
  }

  @GetMapping("/user/myInfo")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  public CommonResponse getMyInformation() {
    CustomerResponse.Information me = customerService.getMe();
    return CommonResponse.success(me, "본인 정보를 조회 했습니다.");
  }

  @PatchMapping("/user/myInfo")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  public CommonResponse patchMyInformation() {
    CustomerResponse.Information me = customerService.getMe();
    return CommonResponse.success(me, "본인 정보를 조회 했습니다.");
  }
}
