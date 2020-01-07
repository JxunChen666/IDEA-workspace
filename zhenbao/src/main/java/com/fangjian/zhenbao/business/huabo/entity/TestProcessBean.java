package com.fangjian.zhenbao.business.huabo.entity;

import java.util.Date;

/**
 * @author FangJian
 * @description: 国标3847检测结果返回数据model
 * @date 2019-07-21 13:52
 */
public class TestProcessBean {
    private Long carId;
    private String carName;
    private Integer carType;
    private Integer discharge;
    private Integer fuelKind;
    private String model;
    private String brand;
    private Date recordDate;
    private String stationName;
    private String stationLineName;
    private Integer testMethod;
    private Integer testType;
    private Integer numberOfTimes;
    private Date testDate;
    private Integer testResult;
    private String number;

    //为了查询，加个时间条件，里面包含开始和结束时间，以 - 分隔，主要看前端传的参数
    private String processTime;
    //查询条件
    private Integer stationId;

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public Integer getDischarge() {
        return discharge;
    }

    public void setDischarge(Integer discharge) {
        this.discharge = discharge;
    }

    public Integer getFuelKind() {
        return fuelKind;
    }

    public void setFuelKind(Integer fuelKind) {
        this.fuelKind = fuelKind;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationLineName() {
        return stationLineName;
    }

    public void setStationLineName(String stationLineName) {
        this.stationLineName = stationLineName;
    }

    public Integer getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(Integer testMethod) {
        this.testMethod = testMethod;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(Integer numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Integer getTestResult() {
        return testResult;
    }

    public void setTestResult(Integer testResult) {
        this.testResult = testResult;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
