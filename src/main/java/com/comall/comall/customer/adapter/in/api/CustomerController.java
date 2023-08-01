package com.comall.comall.customer.adapter.in.api;

import com.comall.comall.customer.application.service.CustomerService;
import com.comall.comall.customer.application.service.dto.CustomerRequest;
import com.comall.comall.customer.domain.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {
  private final CustomerService userService;

  @PostMapping("/signup")
  public ResponseEntity<Customer> signup(@Valid @RequestBody CustomerRequest userDto) {
    return ResponseEntity.ok(userService.signup(userDto));
  }

  @GetMapping("/user")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public ResponseEntity<Customer> getMyUserInfo() {
    return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
  }

  @GetMapping("/user/{username}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<Customer> getUserInfo(@PathVariable String username) {
    return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
  }
}
