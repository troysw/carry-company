package com.carryCompany.carryCompany.vendor.application.outport;

import com.carryCompany.carryCompany.vendor.domain.Vendor;

public interface VendorReader {
    Vendor findByName(String vendorName);
}
