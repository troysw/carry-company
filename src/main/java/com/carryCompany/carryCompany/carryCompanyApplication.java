package com.carryCompany.carryCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class carryCompanyApplication {

  public static void main(String[] args) {
    SpringApplication.run(carryCompanyApplication.class, args);
    System.out.println("--------------carry-company-실행-------------");
  }
}
