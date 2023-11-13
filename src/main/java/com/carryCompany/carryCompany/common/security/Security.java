package com.carryCompany.carryCompany.common.security;


import com.carryCompany.carryCompany.common.exception.ApiException;
import com.carryCompany.carryCompany.common.exception.ErrorCode;
import com.carryCompany.carryCompany.customer.domain.Customer;
import com.carryCompany.carryCompany.customer.external.CustomerRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Security {

  private final CustomerRepository customerRepository;
  private final EntityManager em;


  public boolean isMe(String adminId) {
    final Optional<User> userPrincipal = getCustomerOptional();
    return userPrincipal.map(user -> user.getUsername().equals(adminId)).orElse(false);
  }


  public Customer getMe() {
    User adminOptional = getCustomerOptional().orElseThrow(() -> new ApiException(ErrorCode.NOT_LOGIN));

    return customerRepository.findByCustomerEmail(adminOptional.getUsername())
        .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
  }

  public Optional<User> getCustomerOptional() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (null == authentication || !authentication.isAuthenticated()) {
      return Optional.empty();
    }

    Object principal = authentication.getPrincipal();
    if (!(principal instanceof User admin)) {
      return Optional.empty();
    }

    return Optional.of(admin);
  }

  public User getManagedAdmin() {
    return getManagedAdminOptional().orElseThrow(() -> new ApiException(ErrorCode.NOT_LOGIN));
  }

  public Optional<User> getManagedAdminOptional() {
    return getCustomerOptional().map(em::merge);
  }
}
