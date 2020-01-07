package com.fangjian.zhenbao.business.huabo.entity;

import java.util.Date;

/**
 * @author FangJian
 * @description: obd安装单返回列表bean
 * @date 2019-12-05 11:48
 */
public class ObdInstallModel {
    private String id;

    private String deviceId;

    private Date installDate;

    private Byte feasible;

    private String carName;

    private Byte print;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Byte getFeasible() {
        return feasible;
    }

    public void setFeasible(Byte feasible) {
        this.feasible = feasible;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Byte getPrint() {
        return print;
    }

    public void setPrint(Byte print) {
        this.print = print;
    }
}
