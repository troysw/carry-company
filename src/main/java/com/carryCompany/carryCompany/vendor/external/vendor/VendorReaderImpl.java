package com.carryCompany.carryCompany.vendor.external.vendor;

import com.carryCompany.carryCompany.common.exception.vendor.VendorNotFoundException;
import com.carryCompany.carryCompany.vendor.application.outport.VendorReader;
import com.carryCompany.carryCompany.vendor.domain.Vendor;
import com.carryCompany.carryCompany.vendor.external.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class VendorReaderImpl implements VendorReader {

    private final VendorRepository vendorRepository;

    @Override
    public Vendor findByName(String vendorName) {
        return vendorRepository.findByVendorName(vendorName).orElseThrow(VendorNotFoundException::new);
    }
}
