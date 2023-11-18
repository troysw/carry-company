package com.carryCompany.carryCompany.truckDriver;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.truck.Truck;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class TruckDriver extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long driverId;

  @OneToMany(fetch = FetchType.LAZY)
  private List<Truck> truckList = new ArrayList<>();



}
