package com.carryCompany.carryCompany.vendor.application.service;

import com.carryCompany.carryCompany.order.application.outport.OrderReader;
import com.carryCompany.carryCompany.order.application.outport.OrderStore;
import com.carryCompany.carryCompany.vendor.application.inport.VendorService;
import com.carryCompany.carryCompany.vendor.application.outport.VendorReader;
import com.carryCompany.carryCompany.vendor.application.outport.VendorStore;
import com.carryCompany.carryCompany.vendor.domain.Vendor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorReader vendorReader;
    private final VendorStore vendorStore;

    @Override
    public Vendor findVendorByName(String vendorName) {
        return vendorReader.findByName(vendorName);
    }
}
