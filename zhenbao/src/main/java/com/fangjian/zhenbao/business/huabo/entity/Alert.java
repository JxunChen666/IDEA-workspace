package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;

public class Alert {
    private Integer redisAlertId;

    private Long redisAlertTime;

    private Byte gpsStatus;

    private Byte redisAlertGpsValueLngFlag;

    private Double redisAlertGpsValueLngValue;

    private Byte redisAlertGpsValueLatFlag;

    private Double redisAlertGpsValueLatValue;

    private String redisAlertGpsName;

    private String redisAlertDeviceId;

    private String redisAlertAlertId;

    private String redisAlertAlertName;

    private Long redisAlertTripTime;

    private String collectDate;

    private Integer number;

    private BigDecimal speed;

    private BigDecimal pressure;

    private Integer outputTorque;

    private Integer frictionTorque;

    private BigDecimal rotationSpeed;

    private BigDecimal fuelFlow;

    private BigDecimal scrUp;

    private BigDecimal scrDown;

    private BigDecimal reactor;

    private BigDecimal airInflow;

    private BigDecimal scrIn;

    private BigDecimal scrOut;

    private BigDecimal dpf;

    private Integer engineTemperature;

    private BigDecimal oilPosition;

    private BigDecimal totalMileage;

    private String remark;

    public Integer getRedisAlertId() {
        return redisAlertId;
    }

    public void setRedisAlertId(Integer redisAlertId) {
        this.redisAlertId = redisAlertId;
    }

    public Long getRedisAlertTime() {
        return redisAlertTime;
    }

    public void setRedisAlertTime(Long redisAlertTime) {
        this.redisAlertTime = redisAlertTime;
    }

    public Byte getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(Byte gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public Byte getRedisAlertGpsValueLngFlag() {
        return redisAlertGpsValueLngFlag;
    }

    public void setRedisAlertGpsValueLngFlag(Byte redisAlertGpsValueLngFlag) {
        this.redisAlertGpsValueLngFlag = redisAlertGpsValueLngFlag;
    }

    public Double getRedisAlertGpsValueLngValue() {
        return redisAlertGpsValueLngValue;
    }

    public void setRedisAlertGpsValueLngValue(Double redisAlertGpsValueLngValue) {
        this.redisAlertGpsValueLngValue = redisAlertGpsValueLngValue;
    }

    public Byte getRedisAlertGpsValueLatFlag() {
        return redisAlertGpsValueLatFlag;
    }

    public void setRedisAlertGpsValueLatFlag(Byte redisAlertGpsValueLatFlag) {
        this.redisAlertGpsValueLatFlag = redisAlertGpsValueLatFlag;
    }

    public Double getRedisAlertGpsValueLatValue() {
        return redisAlertGpsValueLatValue;
    }

    public void setRedisAlertGpsValueLatValue(Double redisAlertGpsValueLatValue) {
        this.redisAlertGpsValueLatValue = redisAlertGpsValueLatValue;
    }

    public String getRedisAlertGpsName() {
        return redisAlertGpsName;
    }

    public void setRedisAlertGpsName(String redisAlertGpsName) {
        this.redisAlertGpsName = redisAlertGpsName == null ? null : redisAlertGpsName.trim();
    }

    public String getRedisAlertDeviceId() {
        return redisAlertDeviceId;
    }

    public void setRedisAlertDeviceId(String redisAlertDeviceId) {
        this.redisAlertDeviceId = redisAlertDeviceId == null ? null : redisAlertDeviceId.trim();
    }

    public String getRedisAlertAlertId() {
        return redisAlertAlertId;
    }

    public void setRedisAlertAlertId(String redisAlertAlertId) {
        this.redisAlertAlertId = redisAlertAlertId == null ? null : redisAlertAlertId.trim();
    }

    public String getRedisAlertAlertName() {
        return redisAlertAlertName;
    }

    public void setRedisAlertAlertName(String redisAlertAlertName) {
        this.redisAlertAlertName = redisAlertAlertName == null ? null : redisAlertAlertName.trim();
    }

    public Long getRedisAlertTripTime() {
        return redisAlertTripTime;
    }

    public void setRedisAlertTripTime(Long redisAlertTripTime) {
        this.redisAlertTripTime = redisAlertTripTime;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate == null ? null : collectDate.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public Integer getOutputTorque() {
        return outputTorque;
    }

    public void setOutputTorque(Integer outputTorque) {
        this.outputTorque = outputTorque;
    }

    public Integer getFrictionTorque() {
        return frictionTorque;
    }

    public void setFrictionTorque(Integer frictionTorque) {
        this.frictionTorque = frictionTorque;
    }

    public BigDecimal getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(BigDecimal rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public BigDecimal getFuelFlow() {
        return fuelFlow;
    }

    public void setFuelFlow(BigDecimal fuelFlow) {
        this.fuelFlow = fuelFlow;
    }

    public BigDecimal getScrUp() {
        return scrUp;
    }

    public void setScrUp(BigDecimal scrUp) {
        this.scrUp = scrUp;
    }

    public BigDecimal getScrDown() {
        return scrDown;
    }

    public void setScrDown(BigDecimal scrDown) {
        this.scrDown = scrDown;
    }

    public BigDecimal getReactor() {
        return reactor;
    }

    public void setReactor(BigDecimal reactor) {
        this.reactor = reactor;
    }

    public BigDecimal getAirInflow() {
        return airInflow;
    }

    public void setAirInflow(BigDecimal airInflow) {
        this.airInflow = airInflow;
    }

    public BigDecimal getScrIn() {
        return scrIn;
    }

    public void setScrIn(BigDecimal scrIn) {
        this.scrIn = scrIn;
    }

    public BigDecimal getScrOut() {
        return scrOut;
    }

    public void setScrOut(BigDecimal scrOut) {
        this.scrOut = scrOut;
    }

    public BigDecimal getDpf() {
        return dpf;
    }

    public void setDpf(BigDecimal dpf) {
        this.dpf = dpf;
    }

    public Integer getEngineTemperature() {
        return engineTemperature;
    }

    public void setEngineTemperature(Integer engineTemperature) {
        this.engineTemperature = engineTemperature;
    }

    public BigDecimal getOilPosition() {
        return oilPosition;
    }

    public void setOilPosition(BigDecimal oilPosition) {
        this.oilPosition = oilPosition;
    }

    public BigDecimal getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(BigDecimal totalMileage) {
        this.totalMileage = totalMileage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}