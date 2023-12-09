package com.carryCompany.carryCompany.order.domain;

import com.carryCompany.carryCompany.vendor.domain.Vendor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
@NoArgsConstructor
public class OrderBundle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Unique
    private String humanCode;

    @OneToMany(mappedBy = "bundle", fetch = FetchType.LAZY)
    private List<MainOrder> mainOrders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "fk__vendor__order__order"))
    private Vendor vendor;

    public static OrderBundle create(String humanCode, Vendor vendor) {
        OrderBundle res = new OrderBundle();
        res.setHumanCode(humanCode);
        res.setVendor(vendor);
        return res;
    }
}