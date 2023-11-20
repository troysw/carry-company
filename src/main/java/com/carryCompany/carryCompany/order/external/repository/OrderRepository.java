package com.carryCompany.carryCompany.order.external.repository;

import com.carryCompany.carryCompany.order.domain.MainOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MainOrder, Long> {

}
