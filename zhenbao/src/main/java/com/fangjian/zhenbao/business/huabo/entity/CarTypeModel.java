package com.fangjian.zhenbao.business.huabo.entity;

/**
 * @author FangJian
 * @description: 车辆分类返回的数据模型
 * @date 2019-08-01 15:38
 */
public class CarTypeModel {
    private Integer discharge;//排放阶段
    private Integer userProperty;//使用性质
    private Integer fuelKind;//车辆燃料种类
    private String typeName;//分类id表示意思
    private Integer number;//计数

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getDischarge() {
        return discharge;
    }

    public void setDischarge(Integer discharge) {
        this.discharge = discharge;
    }

    public Integer getUserProperty() {
        return userProperty;
    }

    public void setUserProperty(Integer userProperty) {
        this.userProperty = userProperty;
    }

    public Integer getFuelKind() {
        return fuelKind;
    }

    public void setFuelKind(Integer fuelKind) {
        this.fuelKind = fuelKind;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
