package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;

public class RepairOrder {
    private Long id;

    private Integer userId;

    private Long carId;

    private String name;

    private String mobile;

    private String address;

    private String carName;

    private String engineName;

    private String engineCode;

    private Integer mileage;

    private String faultSymptom;

    private String process;

    private Integer stationId;

    private Integer recordUserId;

    private Long sequence;
    private String sequenceString;

    private BigDecimal totalPrice;

    private Long robOrderId;

    private String chargeId;

    private String payType;

    private BigDecimal payPrice;

    private Long payTime;
    private String payTimeString;

    private Byte state;

    private Long clickPayTime;

    private Integer customer;

    private String testReportId;

    private String number;

    private String payInfo;

    public String getSequenceString() {
        return sequenceString;
    }

    public void setSequenceString(String sequenceString) {
        this.sequenceString = sequenceString;
    }

    public String getPayTimeString() {
        return payTimeString;
    }

    public void setPayTimeString(String payTimeString) {
        this.payTimeString = payTimeString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName == null ? null : engineName.trim();
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode == null ? null : engineCode.trim();
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getFaultSymptom() {
        return faultSymptom;
    }

    public void setFaultSymptom(String faultSymptom) {
        this.faultSymptom = faultSymptom == null ? null : faultSymptom.trim();
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(Integer recordUserId) {
        this.recordUserId = recordUserId;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getRobOrderId() {
        return robOrderId;
    }

    public void setRobOrderId(Long robOrderId) {
        this.robOrderId = robOrderId;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId == null ? null : chargeId.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getClickPayTime() {
        return clickPayTime;
    }

    public void setClickPayTime(Long clickPayTime) {
        this.clickPayTime = clickPayTime;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public String getTestReportId() {
        return testReportId;
    }

    public void setTestReportId(String testReportId) {
        this.testReportId = testReportId == null ? null : testReportId.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo == null ? null : payInfo.trim();
    }
}