package com.fangjian.zhenbao.business.huabo.entity;

import java.util.Date;

public class ObdInstall {
    private String id;

    private Long carId;

    private String deviceId;

    private Date installDate;

    private Integer installUserId;

    private Byte feasible;

    private String remark;

    private Byte print;

    private Integer customer;

    private Integer updateUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Integer getInstallUserId() {
        return installUserId;
    }

    public void setInstallUserId(Integer installUserId) {
        this.installUserId = installUserId;
    }

    public Byte getFeasible() {
        return feasible;
    }

    public void setFeasible(Byte feasible) {
        this.feasible = feasible;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getPrint() {
        return print;
    }

    public void setPrint(Byte print) {
        this.print = print;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }
}