package com.carryCompany.carryCompany.customer.external;

import com.carryCompany.carryCompany.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findOneWithAuthoritiesByCustomerEmail(String username);

  Optional<Customer> findByCustomerEmail(String username);
}
