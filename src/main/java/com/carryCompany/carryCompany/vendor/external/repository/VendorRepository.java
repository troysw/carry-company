package com.carryCompany.carryCompany.vendor.external.repository;

import com.carryCompany.carryCompany.vendor.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    Optional<Vendor> findByVendorName(String vendorName);
}
