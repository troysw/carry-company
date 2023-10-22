package com.finalThird.finalThird.auth.controller;

import com.finalThird.finalThird.auth.controller.dto.Token;
import com.finalThird.finalThird.common.jwt.dto.TokenDto;
import com.finalThird.finalThird.common.jwt.JwtFilter;
import com.finalThird.finalThird.common.jwt.TokenProvider;
import com.finalThird.finalThird.auth.controller.dto.LoginRequest;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.customer.service.CustomUserDetailsService;
import com.finalThird.finalThird.customer.service.CustomerService;
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

    String jwtacc = tokenProvider.createAccessToken(authentication); // 인증정보를 기반으로 JWT 토큰 생성
    String jwtrefresh = tokenProvider.createRefreshToken(authentication); // 인증정보를 기반으로 JWT 토큰 생성

    // 토큰을 Response Header, Body 모두에 넣어준다.
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, jwtacc);

    return new ResponseEntity<>(new TokenDto(jwtacc, jwtrefresh), httpHeaders, HttpStatus.OK);


//    Authentication authenticationToken =
//          new UsernamePasswordAuthenticationToken(loginRequest.getUserEmail(), loginRequest.getPassword());
//
//    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//      // 해당 객체를 SecurityContextHolder에 저장하고
//      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//      // authentication 객체를 createToken 메소드를 통해서 JWT Token을 생성
//      String jwt = tokenProvider.createToken(authenticationToken);
//
//      HttpHeaders httpHeaders = new HttpHeaders();
//      // response header에 jwt token에 넣어줌
//      httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, jwt);
//
//      // tokenDto를 이용해 response body에도 넣어서 리턴
//      return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
  }
