package com.carryCompany.carryCompany.vendor.domain;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.product.domain.ProductItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
public class VendorProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "fk__vendor__product__vendor"))
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productItem_id", foreignKey = @ForeignKey(name = "fk__vendor__product__product"))
    private ProductItem productItem;

    @Size(max = 20)
    private String vendorPrice;

}
