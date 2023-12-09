package com.carryCompany.carryCompany.vendor.application.service;

import com.carryCompany.carryCompany.order.application.inport.ReadOrderService;
import com.carryCompany.carryCompany.order.application.outport.OrderReader;
import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.domain.MainOrder;
import com.carryCompany.carryCompany.vendor.application.inport.ReadVendorService;
import com.carryCompany.carryCompany.vendor.application.outport.VendorReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReadVendorServiceImpl implements ReadVendorService {

    private final VendorReader vendorReader;

}
