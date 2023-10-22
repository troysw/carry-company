package com.finalThird.finalThird.common.jwt.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

  private String accessToken;
  private String refreshToken;
}
