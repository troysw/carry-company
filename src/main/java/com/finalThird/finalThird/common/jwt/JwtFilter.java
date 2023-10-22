package com.finalThird.finalThird.common.jwt;

import com.finalThird.finalThird.common.exception.ApiException;
import com.finalThird.finalThird.common.exception.AuthException;
import com.finalThird.finalThird.common.exception.ErrorCode;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

  private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
  public static final String AUTHORIZATION_HEADER = "Authorization";

  private final TokenProvider tokenProvider;


  // 실제 필터링 로직
  // 토큰의 인증정보를 SecurityContext에 저장하는 역할 수행
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;


    String accessToken = resolveAccessToken(request);
    String refreshToken = resolveRefreshToken(request);

    tokenProvider.tokenAuthentication(response, accessToken, refreshToken);


    String requestURI = request.getRequestURI();

    if (StringUtils.hasText(accessToken) && tokenProvider.validateToken(accessToken)) {
      Authentication authentication = tokenProvider.getAuthentication(accessToken);
      SecurityContextHolder.getContext().setAuthentication(authentication);
      logger.debug("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.getName(), requestURI);
    } else {
      logger.debug("유효한 JWT 토큰이 없습니다, uri: {}", requestURI);
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  // Request Header 에서 토큰 정보를 꺼내오기 위한 메소드
  public String resolveAccessToken(HttpServletRequest request) {
    String token = null;
    String accessTokenHeader = request.getHeader(AUTHORIZATION_HEADER);
    if (accessTokenHeader != null && accessTokenHeader.startsWith("Bearer ")) {
      token = accessTokenHeader.substring(7);
    }
    return token;
  }

  //추후 소켓 이용시
//  public String resolveAccessToken(StompHeaderAccessor accessor) {
//    String token = null;
//    String accessTokenHeader = accessor.getFirstNativeHeader(AUTHORIZATION_HEADER);
//    if (accessTokenHeader != null && accessTokenHeader.startsWith("Bearer ")) {
//      token = accessTokenHeader.substring(7);
//    }
//    return token;
//  }

  public String resolveRefreshToken(HttpServletRequest request) {
    String token = null;
    String accessTokenHeader = request.getHeader("refreshToken");
    if (accessTokenHeader != null && accessTokenHeader.startsWith("Bearer ")) {
      token = accessTokenHeader.substring(7);
    }
    return token;
  }

  //추후 소켓 이용시
//  public String resolveRefreshToken(StompHeaderAccessor accessor) {
//    String token = null;
//    String accessTokenHeader = accessor.getFirstNativeHeader("refresh-token");
//    if (accessTokenHeader != null && accessTokenHeader.startsWith("Bearer ")) {
//      token = accessTokenHeader.substring(7);
//    }
//    return token;
//  }

}
