package com.carryCompany.carryCompany.customer.service;

import com.carryCompany.carryCompany.customer.external.CustomerRepository;
import com.carryCompany.carryCompany.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final CustomerRepository customerRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;


  @Override
  @Transactional
  // 로그인시에 DB에서 유저정보와 권한정보를 가져와서 해당 정보를 기반으로 userdetails.User 객체를 생성해 리턴
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

    return customerRepository.findOneWithAuthoritiesByCustomerEmail(username)
        .map(user -> createUser(username, user))
        .orElseThrow(() -> new UsernameNotFoundException(username + " -> 유저를 찾을 수 없습니다."));
  }

  private org.springframework.security.core.userdetails.User createUser(String username, Customer customer) {
    if (!customer.isActivated()) {
      throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
    }

    List<GrantedAuthority> grantedAuthorities = customer.getAuthorities()
        .stream()
        .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
        .collect(Collectors.toList());

    return new User(customer.getCustomerEmail(), customer.getPassword(), grantedAuthorities);
  }
}