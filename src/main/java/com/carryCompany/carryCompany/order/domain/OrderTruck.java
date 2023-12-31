package com.carryCompany.carryCompany.order.domain;

import com.carryCompany.carryCompany.common.entity.BaseEntity;
import com.carryCompany.carryCompany.truck.domain.Truck;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk__orderTruck__order"))
    private MainOrder mainOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck_id", foreignKey = @ForeignKey(name = "fk__orderTruck__truck"))
    private Truck truck;

    public static OrderTruck create(MainOrder order, Truck truck) {
        OrderTruck res = new OrderTruck();
        res.setTruck(truck);
        res.setMainOrder(order);
        return res;
    }
}
