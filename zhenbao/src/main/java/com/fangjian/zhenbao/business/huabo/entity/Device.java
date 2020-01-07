package com.fangjian.zhenbao.business.huabo.entity;

public class Device {
    private String devId;

    private String devPassword;

    private Byte devIsActive;

    private Byte devIsAdaptation;

    private Byte devType;

    private Long adapteTimestamp;

    private String adapteDate;

    private String iccid;

    private Integer customer;

    private Integer stationId;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public String getDevPassword() {
        return devPassword;
    }

    public void setDevPassword(String devPassword) {
        this.devPassword = devPassword == null ? null : devPassword.trim();
    }

    public Byte getDevIsActive() {
        return devIsActive;
    }

    public void setDevIsActive(Byte devIsActive) {
        this.devIsActive = devIsActive;
    }

    public Byte getDevIsAdaptation() {
        return devIsAdaptation;
    }

    public void setDevIsAdaptation(Byte devIsAdaptation) {
        this.devIsAdaptation = devIsAdaptation;
    }

    public Byte getDevType() {
        return devType;
    }

    public void setDevType(Byte devType) {
        this.devType = devType;
    }

    public Long getAdapteTimestamp() {
        return adapteTimestamp;
    }

    public void setAdapteTimestamp(Long adapteTimestamp) {
        this.adapteTimestamp = adapteTimestamp;
    }

    public String getAdapteDate() {
        return adapteDate;
    }

    public void setAdapteDate(String adapteDate) {
        this.adapteDate = adapteDate == null ? null : adapteDate.trim();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid == null ? null : iccid.trim();
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }
}