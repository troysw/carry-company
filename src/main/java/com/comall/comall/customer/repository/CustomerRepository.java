package com.comall.comall.customer.repository;

import com.comall.comall.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findOneWithAuthoritiesByUsername(String username);
}
