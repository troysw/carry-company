package com.finalThird.finalThird.customer.controller;

import com.finalThird.finalThird.customer.service.CustomerService;
import com.finalThird.finalThird.customer.controller.dto.CustomerRequest;
import com.finalThird.finalThird.customer.domain.Customer;
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
  public ResponseEntity<Customer> signup(@Valid @RequestBody CustomerRequest userDto) {
    return ResponseEntity.ok(customerService.signup(userDto));
  }

  @GetMapping("/user")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public ResponseEntity<Customer> getMyUserInfo() {
    return ResponseEntity.ok(customerService.getMyUserWithAuthorities().get());
  }

  @GetMapping("/user/{username}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<Customer> getUserInfo(@PathVariable String username) {
    return ResponseEntity.ok(customerService.getUserWithAuthorities(username).get());
  }
}
