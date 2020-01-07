package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Car {
    private Long carId;

    private Integer carTypeId;

    private Integer carDistrictId;

    private String carName;

    private Integer carUserId;

    private BigDecimal carCurMileage;

    private BigDecimal carVolumeValue;

    private String carVolumeUnit;

    private Integer carStyleId;

    private Integer carFuelTypeId;

    private Integer carEmissionId;

    private String carDeviceId;

    private Integer isDefault;

    private String chassisCode;

    private String carIdentityCode;

    private String engineCode;

    private Integer customer;

    private String carProduct;

    private String carEngine;

    private String engineProduct;

    private BigDecimal carVolume;

    private Integer cylinder;

    private String oilProvide;

    private BigDecimal ratedPower;

    private Integer ratedSpeed;

    private Integer discharge;

    private BigDecimal baseQuality;

    private BigDecimal maxQuality;

    private Integer pipeNumber;

    private String inStyle;

    private String processType;

    private String processModel;

    private String motorType;

    private String energyType;

    private BigDecimal batteryCapacity;

    private Integer haveDpf;

    private String dpfModel;

    private Integer haveScr;

    private String scrModel;

    private Date exitDate;

    private String ownerName;

    private String ownerPhone;

    private Integer carColor;

    private Integer fuelKind;

    private String fuelType;

    private String driveStyle;

    private String model;

    private String brand;

    private String variator;

    private Integer userProperty;

    private Date recordDate;

    private String checkMethod;

    private Integer haveObd;

    private String obdLocation;

    private String obdType;

    private Integer type;

    private Integer status;

    private Integer carType;

    private String remark;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Integer getCarDistrictId() {
        return carDistrictId;
    }

    public void setCarDistrictId(Integer carDistrictId) {
        this.carDistrictId = carDistrictId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public Integer getCarUserId() {
        return carUserId;
    }

    public void setCarUserId(Integer carUserId) {
        this.carUserId = carUserId;
    }

    public BigDecimal getCarCurMileage() {
        return carCurMileage;
    }

    public void setCarCurMileage(BigDecimal carCurMileage) {
        this.carCurMileage = carCurMileage;
    }

    public BigDecimal getCarVolumeValue() {
        return carVolumeValue;
    }

    public void setCarVolumeValue(BigDecimal carVolumeValue) {
        this.carVolumeValue = carVolumeValue;
    }

    public String getCarVolumeUnit() {
        return carVolumeUnit;
    }

    public void setCarVolumeUnit(String carVolumeUnit) {
        this.carVolumeUnit = carVolumeUnit == null ? null : carVolumeUnit.trim();
    }

    public Integer getCarStyleId() {
        return carStyleId;
    }

    public void setCarStyleId(Integer carStyleId) {
        this.carStyleId = carStyleId;
    }

    public Integer getCarFuelTypeId() {
        return carFuelTypeId;
    }

    public void setCarFuelTypeId(Integer carFuelTypeId) {
        this.carFuelTypeId = carFuelTypeId;
    }

    public Integer getCarEmissionId() {
        return carEmissionId;
    }

    public void setCarEmissionId(Integer carEmissionId) {
        this.carEmissionId = carEmissionId;
    }

    public String getCarDeviceId() {
        return carDeviceId;
    }

    public void setCarDeviceId(String carDeviceId) {
        this.carDeviceId = carDeviceId == null ? null : carDeviceId.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getChassisCode() {
        return chassisCode;
    }

    public void setChassisCode(String chassisCode) {
        this.chassisCode = chassisCode == null ? null : chassisCode.trim();
    }

    public String getCarIdentityCode() {
        return carIdentityCode;
    }

    public void setCarIdentityCode(String carIdentityCode) {
        this.carIdentityCode = carIdentityCode == null ? null : carIdentityCode.trim();
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode == null ? null : engineCode.trim();
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public String getCarProduct() {
        return carProduct;
    }

    public void setCarProduct(String carProduct) {
        this.carProduct = carProduct == null ? null : carProduct.trim();
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine == null ? null : carEngine.trim();
    }

    public String getEngineProduct() {
        return engineProduct;
    }

    public void setEngineProduct(String engineProduct) {
        this.engineProduct = engineProduct == null ? null : engineProduct.trim();
    }

    public BigDecimal getCarVolume() {
        return carVolume;
    }

    public void setCarVolume(BigDecimal carVolume) {
        this.carVolume = carVolume;
    }

    public Integer getCylinder() {
        return cylinder;
    }

    public void setCylinder(Integer cylinder) {
        this.cylinder = cylinder;
    }

    public String getOilProvide() {
        return oilProvide;
    }

    public void setOilProvide(String oilProvide) {
        this.oilProvide = oilProvide == null ? null : oilProvide.trim();
    }

    public BigDecimal getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(BigDecimal ratedPower) {
        this.ratedPower = ratedPower;
    }

    public Integer getRatedSpeed() {
        return ratedSpeed;
    }

    public void setRatedSpeed(Integer ratedSpeed) {
        this.ratedSpeed = ratedSpeed;
    }

    public Integer getDischarge() {
        return discharge;
    }

    public void setDischarge(Integer discharge) {
        this.discharge = discharge;
    }

    public BigDecimal getBaseQuality() {
        return baseQuality;
    }

    public void setBaseQuality(BigDecimal baseQuality) {
        this.baseQuality = baseQuality;
    }

    public BigDecimal getMaxQuality() {
        return maxQuality;
    }

    public void setMaxQuality(BigDecimal maxQuality) {
        this.maxQuality = maxQuality;
    }

    public Integer getPipeNumber() {
        return pipeNumber;
    }

    public void setPipeNumber(Integer pipeNumber) {
        this.pipeNumber = pipeNumber;
    }

    public String getInStyle() {
        return inStyle;
    }

    public void setInStyle(String inStyle) {
        this.inStyle = inStyle == null ? null : inStyle.trim();
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType == null ? null : processType.trim();
    }

    public String getProcessModel() {
        return processModel;
    }

    public void setProcessModel(String processModel) {
        this.processModel = processModel == null ? null : processModel.trim();
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType == null ? null : motorType.trim();
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType == null ? null : energyType.trim();
    }

    public BigDecimal getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(BigDecimal batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getHaveDpf() {
        return haveDpf;
    }

    public void setHaveDpf(Integer haveDpf) {
        this.haveDpf = haveDpf;
    }

    public String getDpfModel() {
        return dpfModel;
    }

    public void setDpfModel(String dpfModel) {
        this.dpfModel = dpfModel == null ? null : dpfModel.trim();
    }

    public Integer getHaveScr() {
        return haveScr;
    }

    public void setHaveScr(Integer haveScr) {
        this.haveScr = haveScr;
    }

    public String getScrModel() {
        return scrModel;
    }

    public void setScrModel(String scrModel) {
        this.scrModel = scrModel == null ? null : scrModel.trim();
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone == null ? null : ownerPhone.trim();
    }

    public Integer getCarColor() {
        return carColor;
    }

    public void setCarColor(Integer carColor) {
        this.carColor = carColor;
    }

    public Integer getFuelKind() {
        return fuelKind;
    }

    public void setFuelKind(Integer fuelKind) {
        this.fuelKind = fuelKind;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType == null ? null : fuelType.trim();
    }

    public String getDriveStyle() {
        return driveStyle;
    }

    public void setDriveStyle(String driveStyle) {
        this.driveStyle = driveStyle == null ? null : driveStyle.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getVariator() {
        return variator;
    }

    public void setVariator(String variator) {
        this.variator = variator == null ? null : variator.trim();
    }

    public Integer getUserProperty() {
        return userProperty;
    }

    public void setUserProperty(Integer userProperty) {
        this.userProperty = userProperty;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod == null ? null : checkMethod.trim();
    }

    public Integer getHaveObd() {
        return haveObd;
    }

    public void setHaveObd(Integer haveObd) {
        this.haveObd = haveObd;
    }

    public String getObdLocation() {
        return obdLocation;
    }

    public void setObdLocation(String obdLocation) {
        this.obdLocation = obdLocation == null ? null : obdLocation.trim();
    }

    public String getObdType() {
        return obdType;
    }

    public void setObdType(String obdType) {
        this.obdType = obdType == null ? null : obdType.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}