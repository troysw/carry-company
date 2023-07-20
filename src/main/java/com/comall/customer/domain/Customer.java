package com.comall.customer.domain;

import com.comall.customer.constant.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Customer {

  @Id
  @Column(name = "customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;

  private String password;

  private LocalDate createDate;

  @Enumerated(EnumType.STRING)
  private Authority authority;
}
