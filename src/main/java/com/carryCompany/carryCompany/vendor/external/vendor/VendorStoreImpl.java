package com.carryCompany.carryCompany.vendor.external.vendor;

import com.carryCompany.carryCompany.order.application.outport.OrderStore;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.vendor.application.outport.VendorStore;
import com.carryCompany.carryCompany.vendor.external.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class VendorStoreImpl implements VendorStore {

    private final VendorRepository vendorRepository;

}
