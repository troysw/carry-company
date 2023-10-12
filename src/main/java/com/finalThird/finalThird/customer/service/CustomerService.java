package com.finalThird.finalThird.customer.service;

import com.finalThird.finalThird.auth.domain.Authority;
import com.finalThird.finalThird.common.config.security.SecurityUtil;
import com.finalThird.finalThird.common.exception.ApiException;
import com.finalThird.finalThird.common.exception.ErrorCode;
import com.finalThird.finalThird.common.exception.customer.CustomerAlreadyExistException;
import com.finalThird.finalThird.common.exception.customer.CustomerNotFoundException;
import com.finalThird.finalThird.customer.controller.dto.CustomerRequest;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.customer.external.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public Customer signup(CustomerRequest userDto) {
    //검증
    if (customerRepository.findOneWithAuthoritiesByCustomerEmail(userDto.getCustomerEmail())
        .orElse(null) != null) {
      throw new CustomerAlreadyExistException();
    }

    // 가입되어 있지 않은 회원이면,
    // 권한 정보 만들고
    Authority authority = Authority.builder()
        .authorityName("ROLE_USER")
        .build();

    // 유저 정보를 만들어서 save
    Customer user = Customer.builder()
        .customerEmail(userDto.getCustomerEmail())
        .password(passwordEncoder.encode(userDto.getPassword()))
        .authorities(Collections.singleton(authority))
        .activated(true)
        .build();

    return customerRepository.save(user);
  }

  // 유저,권한 정보를 가져오는 메소드
  @Transactional(readOnly = true)
  public Optional<Customer> getUserWithAuthorities(String username) {
    return customerRepository.findOneWithAuthoritiesByCustomerEmail(username);
  }

  // 현재 securityContext에 저장된 username의 정보만 가져오는 메소드
  @Transactional(readOnly = true)
  public Optional<Customer> getMyUserWithAuthorities() {
    return SecurityUtil.getCurrentUsername()
        .flatMap(customerRepository::findOneWithAuthoritiesByCustomerEmail);
  }

  public Customer getCustomer(String userEmail) {
    return customerRepository.findByCustomerEmail(userEmail).orElseThrow(CustomerNotFoundException::new);
  }
}
