package com.finalThird.finalThird.auth.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

  @NotNull
  @Size(min = 3, max = 50)
  private String userEmail;

  @NotNull
  @Size(min = 3, max = 100)
  private String password;
}
