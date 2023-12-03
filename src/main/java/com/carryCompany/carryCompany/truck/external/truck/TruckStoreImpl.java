package com.carryCompany.carryCompany.truck.external.truck;

import com.carryCompany.carryCompany.truck.application.outport.TruckStore;
import com.carryCompany.carryCompany.truck.external.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TruckStoreImpl implements TruckStore {

    private final TruckRepository truckRepository;
}
