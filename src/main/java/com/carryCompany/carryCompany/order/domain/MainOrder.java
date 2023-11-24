package com.carryCompany.carryCompany.order.domain;

import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.constant.UnitName;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.truck.constant.TruckType;
import com.carryCompany.carryCompany.vendor.Vendor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter(AccessLevel.PROTECTED)
@Getter
@NoArgsConstructor
public class MainOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long mainOrderId;

    private String vendorName;
    private String manager;

    private String orderCode;

    //입차시간
    private LocalDateTime entranceDate;


    //차 뒷번호
    private String truckBackNumber;

    private String driverName;

    private String productItemName;

    //단위
    private UnitName unitName;

    //수량
    private int quantity;

    //customer(거래처 의 거래처)
    private String marine;

    private String vessel;

    private String location;


    //도착일시
    private LocalDateTime landingDate;

    //출발일시
    private LocalDateTime startDate;

    private String vendorOrderNumber;

    //상차일시
    private LocalDateTime loadingDate;


    //비고
    @Size(max = 1500)
    private String remarks;

    private String truckMemo;

    private TruckType truckType;


    //요금
    private int charge;


    //대기금
    private int waitingCharge;

    //주말
    private int holidayCharge;

    //복적비
    private int consolidationCharge;

    private String memo;

    private String specialMemo;


    @OneToMany
    @OrderBy("createdDate desc")
    private List<OrderProductItem> itemList = new ArrayList<>();


    @OneToMany
    @OrderBy("createdDate desc")
    private List<OrderTruck> truckList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "fk__vendor__order__order"))
    private Vendor vendor;

    public static MainOrder create(MainOrderRequest.MainOrderCreateRequest req) {
        MainOrder res = new MainOrder();
//        res.setVendorName(req.getVendorName());
//        res.setManager(req.getManager());
//        res.setOrderCode(req.getOrderCode());
//        res.setProductItemName(req.getProductItemName());
//        res.setUnitName(req.getUnitName());
//        res.setQuantity(req.getQuantity());
//        res.setMarine(req.getMarine());
//        res.setVessel(req.getVessel());
//        res.setLocation(req.getLocation());
//        res.setLandingDate(req.getLandingDate());
//        res.setLandingTime(req.getLandingTime());
//        res.setStartDate(req.getStartDate());
//        res.setStartTime(req.getStartTime());
//        res.setVendorOrderNumber(req.getVendorOrderNumber());
//        res.setRemarks(req.getRemarks());
//        res.setLoadingDate(req.getLoadingDate());
//        res.setTruckBackNumber(req.getTruckBackNumber());
//        res.setCharge(req.getCharge());
//        res.setConsolidationCharge(req.getConsolidationCharge());
//        res.setEndDate(req.getEndDate());
//        res.setEntranceDate(req.getEntranceDate());
//        res.setHolidayCharge(req.getHolidayCharge());
//        res.setMemo(req.getMemo());
//        res.setSpecialMemo(req.getSpecialMemo());
//        res.setTruckMemo(req.getTruckMemo());
//        res.setTruckType(req.getTruckType());
//        res.setWaitingCharge(req.getWaitingCharge());
//        res.setDriverName(req.getDriverName());
//        vendorId
        return res;
    }

    public OrderResponse.MainOrderResponse toResponse() {
        OrderResponse.MainOrderResponse res = new OrderResponse.MainOrderResponse();
        res.setVendorName(this.getVendorName());
        res.setManager(this.getManager());
        res.setOrderCode(this.getOrderCode());
        res.setTruckBackNumber(this.getTruckBackNumber());
        res.setDriverName(this.getDriverName());
        res.setTruckBackNumber(this.getTruckBackNumber());
        res.setDriverName(this.getDriverName());
        res.setCharge(this.getCharge());
        res.setConsolidationCharge(this.getConsolidationCharge());
        res.setManager(this.getManager());
        res.setVessel(this.getVessel());
        res.setMarine(this.getMarine());
        res.setStartDate(this.getStartDate());
        res.setEntranceDate(this.getEntranceDate());
        res.setLandingDate(this.getLandingDate());
        res.setLoadingDate(this.getLoadingDate());
        res.setRemarks(this.getRemarks());
        res.setVendorOrderNumber(this.getVendorOrderNumber());
        res.setUnitName(UnitName.LITER.toString());
        return res;
    }
}


//    vessel
//            location
//    입차시간
//            도착일시
//    출발일시
//            remarks
//    운송료
//            대기비
//    주말대기비
//            혼적비
//    기타
//            특이사항
