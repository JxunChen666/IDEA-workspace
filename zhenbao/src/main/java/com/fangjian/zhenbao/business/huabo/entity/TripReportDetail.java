package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;

public class TripReportDetail {
    private Integer tripDetailId;

    private Integer tripDetailParentId;

    private Byte tripDetailDevState;

    private Byte tripDetailCarState;

    private Long tripDetailBeginTime;

    private Long tripDetailStopTime;

    private Double tripDetailHeaderDirection;

    private Boolean tripDetailGpsValueLngFlag;

    private Double tripDetailGpsValueLngValue;

    private Byte tripDetailGpsValueLatFlag;

    private Double tripDetailGpsValueLatValue;

    private Long tripDetailTime;

    private Float tripDetailEngineSpeed;

    private Float tripDetailCurSpeed;

    private Float tripDetailCurOilConsumption;

    private Float tripDetailTotalOilConsumption;

    private Float tripDetailCurMileage;

    private Float tripDetailTotalMileage;

    private Float tripDetailCo2;

    private Integer voltage;

    private Integer coolanttemp;

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

    private Integer noxUnqualified;

    private Integer dpfUnqualified;

    private Integer reactorUnqualified;

    //数据不全项增加显示字段
    private String carName;
    private String carIdentityCode;
    private String brand;
    private String modelName;
    private String engineName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarIdentityCode() {
        return carIdentityCode;
    }

    public void setCarIdentityCode(String carIdentityCode) {
        this.carIdentityCode = carIdentityCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public Integer getTripDetailId() {
        return tripDetailId;
    }

    public void setTripDetailId(Integer tripDetailId) {
        this.tripDetailId = tripDetailId;
    }

    public Integer getTripDetailParentId() {
        return tripDetailParentId;
    }

    public void setTripDetailParentId(Integer tripDetailParentId) {
        this.tripDetailParentId = tripDetailParentId;
    }

    public Byte getTripDetailDevState() {
        return tripDetailDevState;
    }

    public void setTripDetailDevState(Byte tripDetailDevState) {
        this.tripDetailDevState = tripDetailDevState;
    }

    public Byte getTripDetailCarState() {
        return tripDetailCarState;
    }

    public void setTripDetailCarState(Byte tripDetailCarState) {
        this.tripDetailCarState = tripDetailCarState;
    }

    public Long getTripDetailBeginTime() {
        return tripDetailBeginTime;
    }

    public void setTripDetailBeginTime(Long tripDetailBeginTime) {
        this.tripDetailBeginTime = tripDetailBeginTime;
    }

    public Long getTripDetailStopTime() {
        return tripDetailStopTime;
    }

    public void setTripDetailStopTime(Long tripDetailStopTime) {
        this.tripDetailStopTime = tripDetailStopTime;
    }

    public Double getTripDetailHeaderDirection() {
        return tripDetailHeaderDirection;
    }

    public void setTripDetailHeaderDirection(Double tripDetailHeaderDirection) {
        this.tripDetailHeaderDirection = tripDetailHeaderDirection;
    }

    public Boolean getTripDetailGpsValueLngFlag() {
        return tripDetailGpsValueLngFlag;
    }

    public void setTripDetailGpsValueLngFlag(Boolean tripDetailGpsValueLngFlag) {
        this.tripDetailGpsValueLngFlag = tripDetailGpsValueLngFlag;
    }

    public Double getTripDetailGpsValueLngValue() {
        return tripDetailGpsValueLngValue;
    }

    public void setTripDetailGpsValueLngValue(Double tripDetailGpsValueLngValue) {
        this.tripDetailGpsValueLngValue = tripDetailGpsValueLngValue;
    }

    public Byte getTripDetailGpsValueLatFlag() {
        return tripDetailGpsValueLatFlag;
    }

    public void setTripDetailGpsValueLatFlag(Byte tripDetailGpsValueLatFlag) {
        this.tripDetailGpsValueLatFlag = tripDetailGpsValueLatFlag;
    }

    public Double getTripDetailGpsValueLatValue() {
        return tripDetailGpsValueLatValue;
    }

    public void setTripDetailGpsValueLatValue(Double tripDetailGpsValueLatValue) {
        this.tripDetailGpsValueLatValue = tripDetailGpsValueLatValue;
    }

    public Long getTripDetailTime() {
        return tripDetailTime;
    }

    public void setTripDetailTime(Long tripDetailTime) {
        this.tripDetailTime = tripDetailTime;
    }

    public Float getTripDetailEngineSpeed() {
        return tripDetailEngineSpeed;
    }

    public void setTripDetailEngineSpeed(Float tripDetailEngineSpeed) {
        this.tripDetailEngineSpeed = tripDetailEngineSpeed;
    }

    public Float getTripDetailCurSpeed() {
        return tripDetailCurSpeed;
    }

    public void setTripDetailCurSpeed(Float tripDetailCurSpeed) {
        this.tripDetailCurSpeed = tripDetailCurSpeed;
    }

    public Float getTripDetailCurOilConsumption() {
        return tripDetailCurOilConsumption;
    }

    public void setTripDetailCurOilConsumption(Float tripDetailCurOilConsumption) {
        this.tripDetailCurOilConsumption = tripDetailCurOilConsumption;
    }

    public Float getTripDetailTotalOilConsumption() {
        return tripDetailTotalOilConsumption;
    }

    public void setTripDetailTotalOilConsumption(Float tripDetailTotalOilConsumption) {
        this.tripDetailTotalOilConsumption = tripDetailTotalOilConsumption;
    }

    public Float getTripDetailCurMileage() {
        return tripDetailCurMileage;
    }

    public void setTripDetailCurMileage(Float tripDetailCurMileage) {
        this.tripDetailCurMileage = tripDetailCurMileage;
    }

    public Float getTripDetailTotalMileage() {
        return tripDetailTotalMileage;
    }

    public void setTripDetailTotalMileage(Float tripDetailTotalMileage) {
        this.tripDetailTotalMileage = tripDetailTotalMileage;
    }

    public Float getTripDetailCo2() {
        return tripDetailCo2;
    }

    public void setTripDetailCo2(Float tripDetailCo2) {
        this.tripDetailCo2 = tripDetailCo2;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getCoolanttemp() {
        return coolanttemp;
    }

    public void setCoolanttemp(Integer coolanttemp) {
        this.coolanttemp = coolanttemp;
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

    public Integer getNoxUnqualified() {
        return noxUnqualified;
    }

    public void setNoxUnqualified(Integer noxUnqualified) {
        this.noxUnqualified = noxUnqualified;
    }

    public Integer getDpfUnqualified() {
        return dpfUnqualified;
    }

    public void setDpfUnqualified(Integer dpfUnqualified) {
        this.dpfUnqualified = dpfUnqualified;
    }

    public Integer getReactorUnqualified() {
        return reactorUnqualified;
    }

    public void setReactorUnqualified(Integer reactorUnqualified) {
        this.reactorUnqualified = reactorUnqualified;
    }
}