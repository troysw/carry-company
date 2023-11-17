package com.carryCompany.carryCompany.customer.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerRequest {


  @Setter
  @Getter
  public static class JoinRequest{

    @NotNull
    @Size(min = 3, max = 50)
    @Email
    private String customerEmail;

    @NotNull
    @Size(min = 3, max = 50)
    private String customerName;

    //역직렬화 할때만 접근 허용
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    private String customerPhone;

    @NotNull
    private String authority;
  }

}
