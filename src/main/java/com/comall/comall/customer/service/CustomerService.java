package com.comall.comall.customer.service;

import com.comall.comall.auth.domain.Authority;
import com.comall.comall.common.config.security.SecurityUtil;
import com.comall.comall.customer.repository.CustomerRepository;
import com.comall.comall.customer.controller.dto.CustomerRequest;
import com.comall.comall.customer.domain.Customer;
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
    if (customerRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
      throw new RuntimeException("이미 가입되어 있는 유저입니다.");
    }

    // 가입되어 있지 않은 회원이면,
    // 권한 정보 만들고
    Authority authority = Authority.builder()
        .authorityName("ROLE_USER")
        .build();

    // 유저 정보를 만들어서 save
    Customer user = Customer.builder()
        .username(userDto.getUsername())
        .password(passwordEncoder.encode(userDto.getPassword()))
        .authorities(Collections.singleton(authority))
        .activated(true)
        .build();

    return customerRepository.save(user);
  }

  // 유저,권한 정보를 가져오는 메소드
  @Transactional(readOnly = true)
  public Optional<Customer> getUserWithAuthorities(String username) {
    return customerRepository.findOneWithAuthoritiesByUsername(username);
  }

  // 현재 securityContext에 저장된 username의 정보만 가져오는 메소드
  @Transactional(readOnly = true)
  public Optional<Customer> getMyUserWithAuthorities() {
    return SecurityUtil.getCurrentUsername()
        .flatMap(customerRepository::findOneWithAuthoritiesByUsername);
  }
}
