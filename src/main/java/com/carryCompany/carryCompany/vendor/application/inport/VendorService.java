package com.carryCompany.carryCompany.vendor.application.inport;

import com.carryCompany.carryCompany.vendor.domain.Vendor;

public interface VendorService {
    Vendor findVendorByName(String vendorName);
}
