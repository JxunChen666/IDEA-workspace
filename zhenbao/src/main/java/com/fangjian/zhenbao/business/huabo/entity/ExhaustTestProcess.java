package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ExhaustTestProcess {
    private Long id;

    private String vin;

    private BigDecimal temperature;

    private BigDecimal pressure;

    private BigDecimal humidity;

    private String analyzerProduct;

    private String analyzerName;

    private String analyzerType;

    private String analyzerTestDate;

    private String chassisProduct;

    private String chassisType;

    private String chassisTestDate;

    private Integer testMethod;

    private String testResultContent;

    private String testMethodBasis;

    private Integer stationId;

    private String stationName;

    private Long stationLineId;

    private String stationLineName;

    private Integer freeRatedSpeed;

    private Integer freeRealitySpeed;

    private BigDecimal freeSmokeFirst;

    private BigDecimal freeSmokeSecond;

    private BigDecimal freeSmokeThird;

    private BigDecimal freeAverage;

    private BigDecimal freeLimits;

    private Integer lugdownRatedSpeed;

    private BigDecimal lugdownReality;

    private BigDecimal lugdownPowerRated;

    private BigDecimal lugdownPowerLimits;

    private BigDecimal lightHundredReality;

    private BigDecimal lightHundredLimits;

    private BigDecimal lightEightyReality;

    private BigDecimal lightEightyLimits;

    private BigDecimal noxEightyReality;

    private BigDecimal noxEightyLimits;

    private BigDecimal smokeHundredReality;

    private BigDecimal smokeHundredLimits;

    private BigDecimal smokeEightyReality;

    private BigDecimal smokeEightyLimits;

    private Integer lingmanSmoke;

    private Integer lingmanLevel;

    private Integer testResult;

    private Integer testType;

    private Date testDate;

    private Integer customer;

    private Integer type;

    private String model;

    private Integer carTypeId;

    private String number;

    private String reportId;

    private Integer testorId;

    private String testorName;

    private Integer authorizerId;

    private String authorizer;

    private Integer agreeId;

    private String agree;

    private Integer numberOfTimes;

    private String remark;

    private Long repairOrderId;

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

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public String getAnalyzerProduct() {
        return analyzerProduct;
    }

    public void setAnalyzerProduct(String analyzerProduct) {
        this.analyzerProduct = analyzerProduct == null ? null : analyzerProduct.trim();
    }

    public String getAnalyzerName() {
        return analyzerName;
    }

    public void setAnalyzerName(String analyzerName) {
        this.analyzerName = analyzerName == null ? null : analyzerName.trim();
    }

    public String getAnalyzerType() {
        return analyzerType;
    }

    public void setAnalyzerType(String analyzerType) {
        this.analyzerType = analyzerType == null ? null : analyzerType.trim();
    }

    public String getAnalyzerTestDate() {
        return analyzerTestDate;
    }

    public void setAnalyzerTestDate(String analyzerTestDate) {
        this.analyzerTestDate = analyzerTestDate == null ? null : analyzerTestDate.trim();
    }

    public String getChassisProduct() {
        return chassisProduct;
    }

    public void setChassisProduct(String chassisProduct) {
        this.chassisProduct = chassisProduct == null ? null : chassisProduct.trim();
    }

    public String getChassisType() {
        return chassisType;
    }

    public void setChassisType(String chassisType) {
        this.chassisType = chassisType == null ? null : chassisType.trim();
    }

    public String getChassisTestDate() {
        return chassisTestDate;
    }

    public void setChassisTestDate(String chassisTestDate) {
        this.chassisTestDate = chassisTestDate == null ? null : chassisTestDate.trim();
    }

    public Integer getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(Integer testMethod) {
        this.testMethod = testMethod;
    }

    public String getTestResultContent() {
        return testResultContent;
    }

    public void setTestResultContent(String testResultContent) {
        this.testResultContent = testResultContent == null ? null : testResultContent.trim();
    }

    public String getTestMethodBasis() {
        return testMethodBasis;
    }

    public void setTestMethodBasis(String testMethodBasis) {
        this.testMethodBasis = testMethodBasis == null ? null : testMethodBasis.trim();
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

    public Integer getFreeRatedSpeed() {
        return freeRatedSpeed;
    }

    public void setFreeRatedSpeed(Integer freeRatedSpeed) {
        this.freeRatedSpeed = freeRatedSpeed;
    }

    public Integer getFreeRealitySpeed() {
        return freeRealitySpeed;
    }

    public void setFreeRealitySpeed(Integer freeRealitySpeed) {
        this.freeRealitySpeed = freeRealitySpeed;
    }

    public BigDecimal getFreeSmokeFirst() {
        return freeSmokeFirst;
    }

    public void setFreeSmokeFirst(BigDecimal freeSmokeFirst) {
        this.freeSmokeFirst = freeSmokeFirst;
    }

    public BigDecimal getFreeSmokeSecond() {
        return freeSmokeSecond;
    }

    public void setFreeSmokeSecond(BigDecimal freeSmokeSecond) {
        this.freeSmokeSecond = freeSmokeSecond;
    }

    public BigDecimal getFreeSmokeThird() {
        return freeSmokeThird;
    }

    public void setFreeSmokeThird(BigDecimal freeSmokeThird) {
        this.freeSmokeThird = freeSmokeThird;
    }

    public BigDecimal getFreeAverage() {
        return freeAverage;
    }

    public void setFreeAverage(BigDecimal freeAverage) {
        this.freeAverage = freeAverage;
    }

    public BigDecimal getFreeLimits() {
        return freeLimits;
    }

    public void setFreeLimits(BigDecimal freeLimits) {
        this.freeLimits = freeLimits;
    }

    public Integer getLugdownRatedSpeed() {
        return lugdownRatedSpeed;
    }

    public void setLugdownRatedSpeed(Integer lugdownRatedSpeed) {
        this.lugdownRatedSpeed = lugdownRatedSpeed;
    }

    public BigDecimal getLugdownReality() {
        return lugdownReality;
    }

    public void setLugdownReality(BigDecimal lugdownReality) {
        this.lugdownReality = lugdownReality;
    }

    public BigDecimal getLugdownPowerRated() {
        return lugdownPowerRated;
    }

    public void setLugdownPowerRated(BigDecimal lugdownPowerRated) {
        this.lugdownPowerRated = lugdownPowerRated;
    }

    public BigDecimal getLugdownPowerLimits() {
        return lugdownPowerLimits;
    }

    public void setLugdownPowerLimits(BigDecimal lugdownPowerLimits) {
        this.lugdownPowerLimits = lugdownPowerLimits;
    }

    public BigDecimal getLightHundredReality() {
        return lightHundredReality;
    }

    public void setLightHundredReality(BigDecimal lightHundredReality) {
        this.lightHundredReality = lightHundredReality;
    }

    public BigDecimal getLightHundredLimits() {
        return lightHundredLimits;
    }

    public void setLightHundredLimits(BigDecimal lightHundredLimits) {
        this.lightHundredLimits = lightHundredLimits;
    }

    public BigDecimal getLightEightyReality() {
        return lightEightyReality;
    }

    public void setLightEightyReality(BigDecimal lightEightyReality) {
        this.lightEightyReality = lightEightyReality;
    }

    public BigDecimal getLightEightyLimits() {
        return lightEightyLimits;
    }

    public void setLightEightyLimits(BigDecimal lightEightyLimits) {
        this.lightEightyLimits = lightEightyLimits;
    }

    public BigDecimal getNoxEightyReality() {
        return noxEightyReality;
    }

    public void setNoxEightyReality(BigDecimal noxEightyReality) {
        this.noxEightyReality = noxEightyReality;
    }

    public BigDecimal getNoxEightyLimits() {
        return noxEightyLimits;
    }

    public void setNoxEightyLimits(BigDecimal noxEightyLimits) {
        this.noxEightyLimits = noxEightyLimits;
    }

    public BigDecimal getSmokeHundredReality() {
        return smokeHundredReality;
    }

    public void setSmokeHundredReality(BigDecimal smokeHundredReality) {
        this.smokeHundredReality = smokeHundredReality;
    }

    public BigDecimal getSmokeHundredLimits() {
        return smokeHundredLimits;
    }

    public void setSmokeHundredLimits(BigDecimal smokeHundredLimits) {
        this.smokeHundredLimits = smokeHundredLimits;
    }

    public BigDecimal getSmokeEightyReality() {
        return smokeEightyReality;
    }

    public void setSmokeEightyReality(BigDecimal smokeEightyReality) {
        this.smokeEightyReality = smokeEightyReality;
    }

    public BigDecimal getSmokeEightyLimits() {
        return smokeEightyLimits;
    }

    public void setSmokeEightyLimits(BigDecimal smokeEightyLimits) {
        this.smokeEightyLimits = smokeEightyLimits;
    }

    public Integer getLingmanSmoke() {
        return lingmanSmoke;
    }

    public void setLingmanSmoke(Integer lingmanSmoke) {
        this.lingmanSmoke = lingmanSmoke;
    }

    public Integer getLingmanLevel() {
        return lingmanLevel;
    }

    public void setLingmanLevel(Integer lingmanLevel) {
        this.lingmanLevel = lingmanLevel;
    }

    public Integer getTestResult() {
        return testResult;
    }

    public void setTestResult(Integer testResult) {
        this.testResult = testResult;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
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

    public Integer getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(Integer authorizerId) {
        this.authorizerId = authorizerId;
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer == null ? null : authorizer.trim();
    }

    public Integer getAgreeId() {
        return agreeId;
    }

    public void setAgreeId(Integer agreeId) {
        this.agreeId = agreeId;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree == null ? null : agree.trim();
    }

    public Integer getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(Integer numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getRepairOrderId() {
        return repairOrderId;
    }

    public void setRepairOrderId(Long repairOrderId) {
        this.repairOrderId = repairOrderId;
    }
}