package com.finalThird.finalThird.common.security;


import com.finalThird.finalThird.common.exception.ApiException;
import com.finalThird.finalThird.common.exception.ErrorCode;
import com.finalThird.finalThird.customer.domain.Customer;
import com.finalThird.finalThird.customer.external.CustomerRepository;
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
    final Optional<User> userPrincipal = getAdminOptional();
    return userPrincipal.map(user -> user.getUsername().equals(adminId)).orElse(false);
  }


  public Customer getMe() {
    User adminOptional = getAdminOptional()
        .orElseThrow(() -> new ApiException(ErrorCode.NOT_LOGIN));
    return customerRepository.findByCustomerEmail(adminOptional.getUsername())
        .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
  }

  public Optional<User> getAdminOptional() {
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
    return getAdminOptional().map(em::merge);
  }
}
