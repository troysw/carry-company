package com.finalThird.finalThird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FinalThirdApplication {

  public static void main(String[] args) {
    SpringApplication.run(FinalThirdApplication.class, args);
  }



}
