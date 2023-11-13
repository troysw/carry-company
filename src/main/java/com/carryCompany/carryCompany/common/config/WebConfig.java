package com.carryCompany.carryCompany.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Value("${jwt.response.header}")
  private String jwtHeader;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .exposedHeaders(jwtHeader, "refresh-token")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
        .allowCredentials(false);
  }

  /*
  @Bean  //기본 페이저블 객체 설정
  public PageableHandlerMethodArgumentResolverCustomizer customize() {
    Pageable unpaged = Pageable.unpaged();
    return p -> p.setFallbackPageable(unpaged);
  }
  */


  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
