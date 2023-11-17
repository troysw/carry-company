package com.carryCompany.carryCompany.truck;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.truckDriver.TruckDriver;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class Truck extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long truckId;

  private String truckModel;

  private String carNumber;

  private String truckMemo;

  @ManyToOne
  @JoinColumn(name = "truckDriver_id", foreignKey = @ForeignKey(name = "fk__truck__truckDriver"))
  private TruckDriver truckDriver;

}
