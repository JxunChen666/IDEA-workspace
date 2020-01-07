package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author FangJian
 * @description: obd故障监控
 * @date 2019-08-04 15:01
 */
public class ObdFaultBean {
    private Long id;
    private String carName;
    private String vin;
    private BigDecimal milMileage;
    private String faultCode;
    private Date testDate;
    private String stationName;
    private String number;
    private Integer faultLampIsUp;
    private Integer type;//查询条件增加字段 0全部 1MIL灯点亮 2OBD异常

    public Integer getFaultLampIsUp() {
        return faultLampIsUp;
    }

    public void setFaultLampIsUp(Integer faultLampIsUp) {
        this.faultLampIsUp = faultLampIsUp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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
        this.faultCode = faultCode;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
