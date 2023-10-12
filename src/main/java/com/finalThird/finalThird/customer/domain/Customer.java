package com.finalThird.finalThird.customer.domain;

import com.finalThird.finalThird.auth.domain.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity // DB의 테이블과 1:1 매핑되는 객체
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements UserDetails {

  @Id
  @Column(name = "customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;

  @Column(name = "customerEmail", length = 50, unique = true)
  private String customerEmail;

  @Column(name = "customerName", length = 50)
  private String customerName;

  @JsonIgnore
  @Column(name = "password", length = 100)
  private String password;

  @Column(name = "nickName", length = 50)
  private String nickName;

  @JsonIgnore
  @Column(name = "activated")
  private boolean activated;

  @Column(name = "customerPhone", length = 50)
  private String customerPhone;


  @ManyToMany
  @JoinTable(
      name = "customer_authority",
      joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
  private Set<Authority> authorities;

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> collect = new ArrayList<>();
    collect.add(new SimpleGrantedAuthority(authorities.toString()));
    return collect;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
