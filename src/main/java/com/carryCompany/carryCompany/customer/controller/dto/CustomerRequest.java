package com.carryCompany.carryCompany.customer.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerRequest {


    @Setter
    @Getter
    public static class JoinRequest {

        @NotNull
        @Size(min = 2, max = 50)
        private String customerEmail;

        @NotNull
        @Size(min = 3, max = 50)
        private String customerName;

        //역직렬화 할때만 접근 허용
        @com.fasterxml.jackson.annotation.JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @NotNull
        @Size(min = 3, max = 100)
        private String password;

        private String customerPhone;

        @NotNull
        private String authority;
    }

}
