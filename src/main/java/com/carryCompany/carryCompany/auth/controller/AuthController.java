package com.carryCompany.carryCompany.auth.controller;

import com.carryCompany.carryCompany.common.exception.ApiException;
import com.carryCompany.carryCompany.common.exception.ErrorCode;
import com.carryCompany.carryCompany.common.exception.customer.CustomerNotFoundException;
import com.carryCompany.carryCompany.common.jwt.dto.TokenDto;
import com.carryCompany.carryCompany.common.jwt.JwtFilter;
import com.carryCompany.carryCompany.common.jwt.TokenProvider;
import com.carryCompany.carryCompany.auth.controller.dto.LoginRequest;
import com.carryCompany.carryCompany.customer.domain.Customer;
import com.carryCompany.carryCompany.customer.service.CustomUserDetailsService;
import com.carryCompany.carryCompany.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

  private final TokenProvider tokenProvider;
  private final CustomerService customerService;
  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final CustomUserDetailsService customUserDetailsService;

  BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @PostMapping("/login")
  public ResponseEntity<TokenDto> loginCustomer(@Valid @RequestBody LoginRequest loginRequest) {
    //검증 로직
    Customer customer = customerService.getCustomer(loginRequest.getUserEmail());

    if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), customer.getPassword())) {
      throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(loginRequest.getUserEmail(), loginRequest.getPassword());

    // CustomUserDetailsServce에서 만든 loadUserByUserName이 실행된다.
    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

    SecurityContextHolder.getContext().setAuthentication(authentication);


    Customer user = customerService.findByEmail(loginRequest.getUserEmail())
            .orElseThrow(CustomerNotFoundException::new);

    HashMap<String,Object> claim = new HashMap<String,Object>();
    claim.put("userId", user.getCustomerId());
    claim.put("userEmail", user.getCustomerEmail());
    claim.put("userName", user.getCustomerName());
    claim.put("userPhone", user.getCustomerPhone());
    claim.put("role", user.getAuthorities().stream().map(auth -> auth + ",").toList());


    String accessToken = tokenProvider.createAccessToken(user.getCustomerEmail(), claim); // 인증정보를 기반으로 JWT 토큰 생성
    String jwtRefreshToken = tokenProvider.createRefreshToken(authentication); // 인증정보를 기반으로 JWT 토큰 생성

    // 토큰을 Response Header, Body 모두에 넣어준다.
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, accessToken);
    httpHeaders.add("refresh-token", jwtRefreshToken);
    return new ResponseEntity<>(new TokenDto(accessToken, jwtRefreshToken), httpHeaders, HttpStatus.OK);
    }
  }
