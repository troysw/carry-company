package com.carryCompany.carryCompany.truck.external.repository;

import com.carryCompany.carryCompany.truck.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

    Optional<Truck> findByTruckBackNumber(String truckBackNumber);
}
