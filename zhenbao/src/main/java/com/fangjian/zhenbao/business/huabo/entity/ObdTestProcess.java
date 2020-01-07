package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ObdTestProcess {
    private Long id;

    private String vin;

    private String obdType;

    private BigDecimal carCurMileage;

    private String engineControlCal;

    private String engineControlCvn;

    private String handleCal;

    private String handleCvn;

    private String otherCal;

    private String otherCvn;

    private Integer obdFaultIsOk;

    private Integer communicationIsOk;

    private String communicationWhy;

    private Integer faultStateIsSame;

    private Integer faultLampIsUp;

    private Integer readyStateUncompleted;

    private String readyState;

    private BigDecimal milMileage;

    private String faultCode;

    private Integer nowProcess;

    private Integer testStyle;

    private Integer testResult;

    private Integer reTest;

    private Integer reTestProcess;

    private Integer reTestResult;

    private Date testDate;

    private Integer testType;

    private String number;

    private String obdProduct;

    private String obdModel;

    private Integer stationId;

    private String stationName;

    private Long stationLineId;

    private String stationLineName;

    private Integer testorId;

    private String testorName;

    private String reportId;

    private String model;

    private Integer carTypeId;

    private Integer customer;

    private Integer type;

    private String remark;

    //为了查询，加个时间条件，里面包含开始和结束时间，以 - 分隔，主要看前端传的参数
    private String processTime;
    //查询条件：开始时间
    private Date beginTime;
    //查询条件：结束时间
    private Date endTime;

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getObdType() {
        return obdType;
    }

    public void setObdType(String obdType) {
        this.obdType = obdType == null ? null : obdType.trim();
    }

    public BigDecimal getCarCurMileage() {
        return carCurMileage;
    }

    public void setCarCurMileage(BigDecimal carCurMileage) {
        this.carCurMileage = carCurMileage;
    }

    public String getEngineControlCal() {
        return engineControlCal;
    }

    public void setEngineControlCal(String engineControlCal) {
        this.engineControlCal = engineControlCal == null ? null : engineControlCal.trim();
    }

    public String getEngineControlCvn() {
        return engineControlCvn;
    }

    public void setEngineControlCvn(String engineControlCvn) {
        this.engineControlCvn = engineControlCvn == null ? null : engineControlCvn.trim();
    }

    public String getHandleCal() {
        return handleCal;
    }

    public void setHandleCal(String handleCal) {
        this.handleCal = handleCal == null ? null : handleCal.trim();
    }

    public String getHandleCvn() {
        return handleCvn;
    }

    public void setHandleCvn(String handleCvn) {
        this.handleCvn = handleCvn == null ? null : handleCvn.trim();
    }

    public String getOtherCal() {
        return otherCal;
    }

    public void setOtherCal(String otherCal) {
        this.otherCal = otherCal == null ? null : otherCal.trim();
    }

    public String getOtherCvn() {
        return otherCvn;
    }

    public void setOtherCvn(String otherCvn) {
        this.otherCvn = otherCvn == null ? null : otherCvn.trim();
    }

    public Integer getObdFaultIsOk() {
        return obdFaultIsOk;
    }

    public void setObdFaultIsOk(Integer obdFaultIsOk) {
        this.obdFaultIsOk = obdFaultIsOk;
    }

    public Integer getCommunicationIsOk() {
        return communicationIsOk;
    }

    public void setCommunicationIsOk(Integer communicationIsOk) {
        this.communicationIsOk = communicationIsOk;
    }

    public String getCommunicationWhy() {
        return communicationWhy;
    }

    public void setCommunicationWhy(String communicationWhy) {
        this.communicationWhy = communicationWhy == null ? null : communicationWhy.trim();
    }

    public Integer getFaultStateIsSame() {
        return faultStateIsSame;
    }

    public void setFaultStateIsSame(Integer faultStateIsSame) {
        this.faultStateIsSame = faultStateIsSame;
    }

    public Integer getFaultLampIsUp() {
        return faultLampIsUp;
    }

    public void setFaultLampIsUp(Integer faultLampIsUp) {
        this.faultLampIsUp = faultLampIsUp;
    }

    public Integer getReadyStateUncompleted() {
        return readyStateUncompleted;
    }

    public void setReadyStateUncompleted(Integer readyStateUncompleted) {
        this.readyStateUncompleted = readyStateUncompleted;
    }

    public String getReadyState() {
        return readyState;
    }

    public void setReadyState(String readyState) {
        this.readyState = readyState == null ? null : readyState.trim();
    }

    public BigDecimal getMilMileage() {
        return milMileage;
    }

    public void setMilMileage(BigDecimal milMileage) {
        this.milMileage = milMileage;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
    }

    public Integer getNowProcess() {
        return nowProcess;
    }

    public void setNowProcess(Integer nowProcess) {
        this.nowProcess = nowProcess;
    }

    public Integer getTestStyle() {
        return testStyle;
    }

    public void setTestStyle(Integer testStyle) {
        this.testStyle = testStyle;
    }

    public Integer getTestResult() {
        return testResult;
    }

    public void setTestResult(Integer testResult) {
        this.testResult = testResult;
    }

    public Integer getReTest() {
        return reTest;
    }

    public void setReTest(Integer reTest) {
        this.reTest = reTest;
    }

    public Integer getReTestProcess() {
        return reTestProcess;
    }

    public void setReTestProcess(Integer reTestProcess) {
        this.reTestProcess = reTestProcess;
    }

    public Integer getReTestResult() {
        return reTestResult;
    }

    public void setReTestResult(Integer reTestResult) {
        this.reTestResult = reTestResult;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getObdProduct() {
        return obdProduct;
    }

    public void setObdProduct(String obdProduct) {
        this.obdProduct = obdProduct == null ? null : obdProduct.trim();
    }

    public String getObdModel() {
        return obdModel;
    }

    public void setObdModel(String obdModel) {
        this.obdModel = obdModel == null ? null : obdModel.trim();
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public Long getStationLineId() {
        return stationLineId;
    }

    public void setStationLineId(Long stationLineId) {
        this.stationLineId = stationLineId;
    }

    public String getStationLineName() {
        return stationLineName;
    }

    public void setStationLineName(String stationLineName) {
        this.stationLineName = stationLineName == null ? null : stationLineName.trim();
    }

    public Integer getTestorId() {
        return testorId;
    }

    public void setTestorId(Integer testorId) {
        this.testorId = testorId;
    }

    public String getTestorName() {
        return testorName;
    }

    public void setTestorName(String testorName) {
        this.testorName = testorName == null ? null : testorName.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}