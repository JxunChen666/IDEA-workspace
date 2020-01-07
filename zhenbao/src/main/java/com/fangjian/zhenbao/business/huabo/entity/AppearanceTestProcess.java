package com.fangjian.zhenbao.business.huabo.entity;

import java.util.Date;

public class AppearanceTestProcess {
    private Long id;

    private String vin;

    private Integer same;

    private Integer machineStatus;

    private Integer pollutionControl;

    private Integer electricallyPump;

    private Integer meterStatus;

    private Integer machineFault;

    private Integer blackSmoke;

    private Integer gasSystem;

    private Integer liquidLeakage;

    private Integer haveObd;

    private Integer tirePressure;

    private Integer tireStatus;

    private Integer accessoryEquipment;

    private Integer interruptFunction;

    private Integer oilUnusual;

    private Integer workMethod;

    private Integer testType;

    private Integer testResult;

    private Integer stationId;

    private String stationName;

    private Long stationLineId;

    private String stationLineName;

    private Integer testorId;

    private String testorName;

    private String reportId;

    private Integer carTypeId;

    private Integer customer;

    private Integer type;

    private Date testDate;

    private String number;

    private String remark;

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

    public Integer getSame() {
        return same;
    }

    public void setSame(Integer same) {
        this.same = same;
    }

    public Integer getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(Integer machineStatus) {
        this.machineStatus = machineStatus;
    }

    public Integer getPollutionControl() {
        return pollutionControl;
    }

    public void setPollutionControl(Integer pollutionControl) {
        this.pollutionControl = pollutionControl;
    }

    public Integer getElectricallyPump() {
        return electricallyPump;
    }

    public void setElectricallyPump(Integer electricallyPump) {
        this.electricallyPump = electricallyPump;
    }

    public Integer getMeterStatus() {
        return meterStatus;
    }

    public void setMeterStatus(Integer meterStatus) {
        this.meterStatus = meterStatus;
    }

    public Integer getMachineFault() {
        return machineFault;
    }

    public void setMachineFault(Integer machineFault) {
        this.machineFault = machineFault;
    }

    public Integer getBlackSmoke() {
        return blackSmoke;
    }

    public void setBlackSmoke(Integer blackSmoke) {
        this.blackSmoke = blackSmoke;
    }

    public Integer getGasSystem() {
        return gasSystem;
    }

    public void setGasSystem(Integer gasSystem) {
        this.gasSystem = gasSystem;
    }

    public Integer getLiquidLeakage() {
        return liquidLeakage;
    }

    public void setLiquidLeakage(Integer liquidLeakage) {
        this.liquidLeakage = liquidLeakage;
    }

    public Integer getHaveObd() {
        return haveObd;
    }

    public void setHaveObd(Integer haveObd) {
        this.haveObd = haveObd;
    }

    public Integer getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(Integer tirePressure) {
        this.tirePressure = tirePressure;
    }

    public Integer getTireStatus() {
        return tireStatus;
    }

    public void setTireStatus(Integer tireStatus) {
        this.tireStatus = tireStatus;
    }

    public Integer getAccessoryEquipment() {
        return accessoryEquipment;
    }

    public void setAccessoryEquipment(Integer accessoryEquipment) {
        this.accessoryEquipment = accessoryEquipment;
    }

    public Integer getInterruptFunction() {
        return interruptFunction;
    }

    public void setInterruptFunction(Integer interruptFunction) {
        this.interruptFunction = interruptFunction;
    }

    public Integer getOilUnusual() {
        return oilUnusual;
    }

    public void setOilUnusual(Integer oilUnusual) {
        this.oilUnusual = oilUnusual;
    }

    public Integer getWorkMethod() {
        return workMethod;
    }

    public void setWorkMethod(Integer workMethod) {
        this.workMethod = workMethod;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getTestResult() {
        return testResult;
    }

    public void setTestResult(Integer testResult) {
        this.testResult = testResult;
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

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}