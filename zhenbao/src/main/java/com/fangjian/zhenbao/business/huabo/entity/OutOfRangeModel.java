package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;

/**
 * @author FangJian
 * @description: 疑似NOx排放不合格返回数据模型
 * @date 2019-08-06 14:02
 */
public class OutOfRangeModel {
    private String carName;
    private String carIdentityCode;
    private Integer discharge;
    private String brand;
    private String modelName;
    private String engineName;
    private BigDecimal scrDown;
    private String collectDate;
    private BigDecimal dpf;
    private BigDecimal reactor;

    public BigDecimal getReactor() {
        return reactor;
    }

    public void setReactor(BigDecimal reactor) {
        this.reactor = reactor;
    }

    public BigDecimal getDpf() {
        return dpf;
    }

    public void setDpf(BigDecimal dpf) {
        this.dpf = dpf;
    }

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

    public Integer getDischarge() {
        return discharge;
    }

    public void setDischarge(Integer discharge) {
        this.discharge = discharge;
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

    public BigDecimal getScrDown() {
        return scrDown;
    }

    public void setScrDown(BigDecimal scrDown) {
        this.scrDown = scrDown;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }
}
