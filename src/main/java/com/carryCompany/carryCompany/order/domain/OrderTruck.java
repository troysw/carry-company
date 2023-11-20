package com.carryCompany.carryCompany.order.domain;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.truck.Truck;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
@NoArgsConstructor
public class OrderTruck extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderTruckId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk__orderTruck__order"))
    private MainOrder mainOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck_id", foreignKey = @ForeignKey(name = "fk__orderTruck__truck"))
    private Truck truck;
}
