package com.carryCompany.carryCompany.truck.domain;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.truck.application.service.dto.TruckResponse;
import com.carryCompany.carryCompany.truck.constant.TruckType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

  @NotNull
  private String truckBackNumber;

  private String truckFullNumber;

  private String truckMemo;

  private TruckType truckType;

  @ManyToOne
  @JoinColumn(name = "truckDriver_id", foreignKey = @ForeignKey(name = "fk__truck__truckDriver"))
  private TruckDriver truckDriver;

  public TruckResponse.MainTruck toResponse() {
    TruckResponse.MainTruck res = new TruckResponse.MainTruck();
    res.setId(this.getTruckId());
    res.setTruckType(this.getTruckType());
    res.setDriverName(this.getTruckDriver().getDriverName());
    res.setTruckBackNumber(this.getTruckBackNumber());
    res.setTruckFullNumber(this.getTruckFullNumber());
    return res;
  }
}
