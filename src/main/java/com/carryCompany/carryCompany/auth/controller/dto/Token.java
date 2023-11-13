package com.carryCompany.carryCompany.auth.controller.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {
  private String grantType;
  private String accessToken;
  private String refreshToken;
  private String key;
}
