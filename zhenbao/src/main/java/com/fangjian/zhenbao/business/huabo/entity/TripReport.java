package com.fangjian.zhenbao.business.huabo.entity;

public class TripReport {
    private Integer tripId;

    private String tripDeviceId;

    private Long tripBeginTime;
    private String beginTime;//开始时间，已转化好

    private Long tripEndTime;
    private String endTime;//结束时间，已转化好

    private Byte tripBeginGpsValueLngFlag;

    private Double tripBeginGpsValueLngValue;

    private Byte tripBeginGpsValueLatFlag;

    private Double tripBeginGpsValueLatValue;

    private String tripBeginGpsName;

    private Byte tripEndGpsValueLngFlag;

    private Double tripEndGpsValueLngValue;

    private Byte tripEndGpsValueLatFlag;

    private Double tripEndGpsValueLatValue;

    private String tripEndGpsName;

    private Float tripToalTime;
    private String totalTime;//行程的总时间，已转化好

    private Float tripTotalMileage;

    private Float tripTotalFuelConsumption;

    private Long tripCreateTime;


    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getTripDeviceId() {
        return tripDeviceId;
    }

    public void setTripDeviceId(String tripDeviceId) {
        this.tripDeviceId = tripDeviceId == null ? null : tripDeviceId.trim();
    }

    public Long getTripBeginTime() {
        return tripBeginTime;
    }

    public void setTripBeginTime(Long tripBeginTime) {
        this.tripBeginTime = tripBeginTime;
    }

    public Long getTripEndTime() {
        return tripEndTime;
    }

    public void setTripEndTime(Long tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public Byte getTripBeginGpsValueLngFlag() {
        return tripBeginGpsValueLngFlag;
    }

    public void setTripBeginGpsValueLngFlag(Byte tripBeginGpsValueLngFlag) {
        this.tripBeginGpsValueLngFlag = tripBeginGpsValueLngFlag;
    }

    public Double getTripBeginGpsValueLngValue() {
        return tripBeginGpsValueLngValue;
    }

    public void setTripBeginGpsValueLngValue(Double tripBeginGpsValueLngValue) {
        this.tripBeginGpsValueLngValue = tripBeginGpsValueLngValue;
    }

    public Byte getTripBeginGpsValueLatFlag() {
        return tripBeginGpsValueLatFlag;
    }

    public void setTripBeginGpsValueLatFlag(Byte tripBeginGpsValueLatFlag) {
        this.tripBeginGpsValueLatFlag = tripBeginGpsValueLatFlag;
    }

    public Double getTripBeginGpsValueLatValue() {
        return tripBeginGpsValueLatValue;
    }

    public void setTripBeginGpsValueLatValue(Double tripBeginGpsValueLatValue) {
        this.tripBeginGpsValueLatValue = tripBeginGpsValueLatValue;
    }

    public String getTripBeginGpsName() {
        return tripBeginGpsName;
    }

    public void setTripBeginGpsName(String tripBeginGpsName) {
        this.tripBeginGpsName = tripBeginGpsName == null ? null : tripBeginGpsName.trim();
    }

    public Byte getTripEndGpsValueLngFlag() {
        return tripEndGpsValueLngFlag;
    }

    public void setTripEndGpsValueLngFlag(Byte tripEndGpsValueLngFlag) {
        this.tripEndGpsValueLngFlag = tripEndGpsValueLngFlag;
    }

    public Double getTripEndGpsValueLngValue() {
        return tripEndGpsValueLngValue;
    }

    public void setTripEndGpsValueLngValue(Double tripEndGpsValueLngValue) {
        this.tripEndGpsValueLngValue = tripEndGpsValueLngValue;
    }

    public Byte getTripEndGpsValueLatFlag() {
        return tripEndGpsValueLatFlag;
    }

    public void setTripEndGpsValueLatFlag(Byte tripEndGpsValueLatFlag) {
        this.tripEndGpsValueLatFlag = tripEndGpsValueLatFlag;
    }

    public Double getTripEndGpsValueLatValue() {
        return tripEndGpsValueLatValue;
    }

    public void setTripEndGpsValueLatValue(Double tripEndGpsValueLatValue) {
        this.tripEndGpsValueLatValue = tripEndGpsValueLatValue;
    }

    public String getTripEndGpsName() {
        return tripEndGpsName;
    }

    public void setTripEndGpsName(String tripEndGpsName) {
        this.tripEndGpsName = tripEndGpsName == null ? null : tripEndGpsName.trim();
    }

    public Float getTripToalTime() {
        return tripToalTime;
    }

    public void setTripToalTime(Float tripToalTime) {
        this.tripToalTime = tripToalTime;
    }

    public Float getTripTotalMileage() {
        return tripTotalMileage;
    }

    public void setTripTotalMileage(Float tripTotalMileage) {
        this.tripTotalMileage = tripTotalMileage;
    }

    public Float getTripTotalFuelConsumption() {
        return tripTotalFuelConsumption;
    }

    public void setTripTotalFuelConsumption(Float tripTotalFuelConsumption) {
        this.tripTotalFuelConsumption = tripTotalFuelConsumption;
    }

    public Long getTripCreateTime() {
        return tripCreateTime;
    }

    public void setTripCreateTime(Long tripCreateTime) {
        this.tripCreateTime = tripCreateTime;
    }
}