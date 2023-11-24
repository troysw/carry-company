package com.carryCompany.carryCompany.vendor;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class VendorManager extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long managerId;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "fk__vendor__vendorManager"))
  private Vendor vendor;

}
