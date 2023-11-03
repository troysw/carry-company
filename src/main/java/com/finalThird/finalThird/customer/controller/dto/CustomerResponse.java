package com.finalThird.finalThird.customer.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

  @Getter
  @Setter
  public static class Information {

    private String customerEmail;
    private String customerName;
    private String customerNickName;
    private String customerPhone;
  }

  @Setter
  @Getter
  public static class JoinResponse{

    @NotNull
    @Size(min = 3, max = 50)
    @Email
    private String customerEmail;

    @NotNull
    @Size(min = 3, max = 50)
    private String customerName;

    @NotNull
    @Size(min = 2, max = 50)
    private String customerNickName;

    //역직렬화 할때만 접근 허용
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    private String customerPhone;
  }

}
