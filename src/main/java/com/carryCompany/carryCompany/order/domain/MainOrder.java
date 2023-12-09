package com.carryCompany.carryCompany.order.domain;

import com.carryCompany.carryCompany.order.application.service.dto.OrderResponse;
import com.carryCompany.carryCompany.order.controller.dto.MainOrderRequest;
import com.carryCompany.carryCompany.vendor.domain.Vendor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String humanCode;
    private String workingDay;
    private String vendorName;
    private String manager;
    private String orderCode;
    private String productItemName;
    private String unitName;
    private int quantity;
    private String marine;
    private String vessel;
    private String location;
    private String landingDate;
    private String landingTime;
    private String startDate;
    private String startTime;
    private String vendorOrderNumber;
    private String remarks;
    private String loadingDate;
    private String truckBackNumber;
    private String uploadingDate;
    private String truckFullNumber;
    private int holidayCharge;
    private int waitingCharge;
    private int consolidationCharge;
    private int charge;
    private String driverName;
    private int otherCharge;
    private int finalCharge;
    private String personalTruckFullNumber;
    private int personalCharge;
    private String personalDriverName;
    private int personalHolidayCharge;
    private int personalWaitingCharge;
    private int personalOtherCharge;
    private int personalFinalCharge;
    private String personalSpecialMemo;
    private String memo;
    private String specialMemo;
    private String endDate;
    private String entranceDate;
    private String truckMemo;
    private String truckType;
    private String tripManage;

    @OneToMany
    @OrderBy("createdDate desc")
    private List<OrderProductItem> itemList = new ArrayList<>();

    @OneToOne
    @OrderBy("createdDate desc")
    private OrderTruck truck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "fk__vendor__order__order"))
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bundle_id", foreignKey = @ForeignKey(name = "fk__bundle__order__bundle"))
    private OrderBundle bundle;

    public static MainOrder create(MainOrderRequest.MainOrderCreateRequest req, OrderBundle bundle, Vendor vendor) {
        MainOrder res = new MainOrder();
        res.setVendor(vendor);
        res.setBundle(bundle);
        res.setHumanCode(req.getHumanCode());
        res.setWorkingDay(req.getWorkingDay());
        res.setVendorName(req.getVendorName());
        res.setManager(req.getManager());
        res.setOrderCode(req.getOrderCode());
        res.setProductItemName(req.getProductItemName());
        res.setUnitName(req.getUnitName());
        res.setQuantity(req.getQuantity());
        res.setMarine(req.getMarine());
        res.setVessel(req.getVessel());
        res.setLocation(req.getLocation());
        res.setLandingDate(req.getLandingDate());
        res.setLandingTime(req.getLandingTime());
        res.setStartDate(req.getStartDate());
        res.setStartTime(req.getStartTime());
        res.setVendorOrderNumber(req.getVendorOrderNumber());
        res.setRemarks(req.getRemarks());
        res.setLoadingDate(req.getLoadingDate());
        res.setTruckBackNumber(req.getTruckBackNumber());
        res.setUploadingDate(req.getUploadingDate());
        res.setTruckFullNumber(req.getTruckFullNumber());
        res.setHolidayCharge(req.getHolidayCharge());
        res.setWaitingCharge(req.getWaitingCharge());
        res.setConsolidationCharge(req.getConsolidationCharge());
        res.setCharge(req.getCharge());
        res.setDriverName(req.getDriverName());
        res.setOtherCharge(req.getOtherCharge());
        res.setFinalCharge(req.getFinalCharge());
        res.setPersonalTruckFullNumber(req.getPersonalTruckFullNumber());
        res.setPersonalCharge(req.getPersonalCharge());
        res.setPersonalDriverName(req.getPersonalDriverName());
        res.setPersonalHolidayCharge(req.getPersonalHolidayCharge());
        res.setPersonalWaitingCharge(req.getPersonalWaitingCharge());
        res.setPersonalOtherCharge(req.getPersonalOtherCharge());
        res.setPersonalFinalCharge(req.getPersonalFinalCharge());
        res.setPersonalSpecialMemo(req.getPersonalSpecialMemo());
        res.setMemo(req.getMemo());
        res.setSpecialMemo(req.getSpecialMemo());
        res.setEndDate(req.getEndDate());
        res.setEntranceDate(req.getEntranceDate());
        res.setTruckMemo(req.getTruckMemo());
        res.setTruckType(req.getTruckType());
        res.setTripManage(req.getTripManage());
        return res;
    }

    public OrderResponse.MainOrderResponse toResponse() {
        OrderResponse.MainOrderResponse res = new OrderResponse.MainOrderResponse();
        res.setBundleId(this.getBundle().getId());
        res.setOrderId(this.getMainOrderId());
        res.setHumanCode(this.getHumanCode());
        res.setWorkingDay(this.getWorkingDay());
        res.setVendorName(this.getVendorName());
        res.setManager(this.getManager());
        res.setOrderCode(this.getOrderCode());
        res.setProductItemName(this.getProductItemName());
        res.setUnitName(this.getUnitName());
        res.setQuantity(this.getQuantity());
        res.setMarine(this.getMarine());
        res.setVessel(this.getVessel());
        res.setLocation(this.getLocation());
        res.setLandingDate(this.getLandingDate());
        res.setLandingTime(this.getLandingTime());
        res.setStartDate(this.getStartDate());
        res.setStartTime(this.getStartTime());
        res.setVendorOrderNumber(this.getVendorOrderNumber());
        res.setRemarks(this.getRemarks());
        res.setLoadingDate(this.getLoadingDate());
        res.setTruckBackNumber(this.getTruckBackNumber());
        res.setUploadingDate(this.getUploadingDate());
        res.setTruckFullNumber(this.getTruckFullNumber());
        res.setHolidayCharge(this.getHolidayCharge());
        res.setWaitingCharge(this.getWaitingCharge());
        res.setConsolidationCharge(this.getConsolidationCharge());
        res.setCharge(this.getCharge());
        res.setDriverName(this.getDriverName());
        res.setOtherCharge(this.getOtherCharge());
        res.setFinalCharge(this.getFinalCharge());
        res.setPersonalTruckFullNumber(this.getPersonalTruckFullNumber());
        res.setPersonalCharge(this.getPersonalCharge());
        res.setPersonalDriverName(this.getPersonalDriverName());
        res.setPersonalHolidayCharge(this.getPersonalHolidayCharge());
        res.setPersonalWaitingCharge(this.getPersonalWaitingCharge());
        res.setPersonalOtherCharge(this.getPersonalOtherCharge());
        res.setPersonalFinalCharge(this.getPersonalFinalCharge());
        res.setPersonalSpecialMemo(this.getPersonalSpecialMemo());
        res.setMemo(this.getMemo());
        res.setSpecialMemo(this.getSpecialMemo());
        res.setEndDate(this.getEndDate());
        res.setEntranceDate(this.getEntranceDate());
        res.setTruckMemo(this.getTruckMemo());
        res.setTruckType(this.getTruckType());
        res.setTripManage(this.getTripManage());
        return res;
    }
}