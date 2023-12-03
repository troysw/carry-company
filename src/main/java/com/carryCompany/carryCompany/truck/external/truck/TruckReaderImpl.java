package com.carryCompany.carryCompany.truck.external.truck;

import com.carryCompany.carryCompany.truck.application.outport.TruckReader;
import com.carryCompany.carryCompany.truck.domain.Truck;
import com.carryCompany.carryCompany.truck.external.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class TruckReaderImpl implements TruckReader {

    private final TruckRepository truckRepository;

    @Override
    public List<Truck> findAll() {
        return truckRepository.findAll();
    }
}
