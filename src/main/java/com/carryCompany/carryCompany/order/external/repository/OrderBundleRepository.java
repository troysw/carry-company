package com.carryCompany.carryCompany.order.external.repository;

import com.carryCompany.carryCompany.order.domain.OrderBundle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBundleRepository extends JpaRepository<OrderBundle, Long> {
}
