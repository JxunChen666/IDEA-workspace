package com.fangjian.zhenbao.business.huabo.entity;

import java.util.Date;

public class HuaboCar {
    private Long carId;

    private Integer carTypeId;

    private Integer carDistrictId;

    private String carName;

    private Integer carUserId;

    private String carDeviceId;

    private String vin;

    private Integer customer;

    private Date sequence;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Integer getCarDistrictId() {
        return carDistrictId;
    }

    public void setCarDistrictId(Integer carDistrictId) {
        this.carDistrictId = carDistrictId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public Integer getCarUserId() {
        return carUserId;
    }

    public void setCarUserId(Integer carUserId) {
        this.carUserId = carUserId;
    }

    public String getCarDeviceId() {
        return carDeviceId;
    }

    public void setCarDeviceId(String carDeviceId) {
        this.carDeviceId = carDeviceId == null ? null : carDeviceId.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Date getSequence() {
        return sequence;
    }

    public void setSequence(Date sequence) {
        this.sequence = sequence;
    }
}