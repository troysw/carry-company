package com.carryCompany.carryCompany.vendor;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class Vendor extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long vendorId;

  @Size(max = 60)
  @NotNull
  private String vendorName;

  @Size(max = 20)
  private String vendorCeo;

  @Size(max = 60)
  private String vendorManager;

  @Size(max = 60)
  private String vendorManagerPhone;

  @Size(max = 60)
  private String vendorTelNumber;

  private String vendorState;


}
