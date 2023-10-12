package com.finalThird.finalThird.common.config.security;

import com.finalThird.finalThird.common.jwt.JwtAccessDeniedHandler;
import com.finalThird.finalThird.common.jwt.JwtAuthenticationEntryPoint;
import com.finalThird.finalThird.common.jwt.JwtFilter;
import com.finalThird.finalThird.common.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
  private final TokenProvider tokenProvider;


  // BCryptPasswordEncoder
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // csrf-disable
    http.csrf(AbstractHttpConfigurer::disable);
    //cors - disable
    http.cors(AbstractHttpConfigurer::disable);

    http.httpBasic(AbstractHttpConfigurer::disable);

    //form-login-disable
    http.formLogin(AbstractHttpConfigurer::disable);


    //no session
    http.sessionManagement(config ->
        config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    //exception handling
    http.exceptionHandling(config ->
        config
            //인증정보 없을때 401
            .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            //권한 없을때 403
            .accessDeniedHandler(jwtAccessDeniedHandler)
    );

    http.authorizeHttpRequests(
        (auth) -> {
          auth.requestMatchers("/api/**").permitAll();
          auth.requestMatchers("/api/authenticate").permitAll(); // 로그인 api
          auth.requestMatchers("/api/signup").permitAll(); // 회원가입 api
          auth.requestMatchers("/api/login").permitAll(); // 회원가입 api
          auth.requestMatchers("/favicon.ico").permitAll();
          auth.anyRequest().authenticated();// 그 외 인증 없이 접근X
        }
    );

    http.addFilterBefore(new JwtFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
