package com.fangjian.zhenbao.business.huabo.entity;

import java.io.Serializable;

/**
 * @author FangJian
 * @description: 终端设备管理bean
 * @date 2019-03-08 15:12
 */
public class DeviceModel implements Serializable{

    private static final long serialVersionUID = 8161975885282976461L;

    //盒子序列号，盒子sim卡号，持有人，持有人电话，激活日期，操作
    private String devId;
    private String iccid;
    private Long adapteTimestamp;
    private String name;
    private String phone;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public Long getAdapteTimestamp() {
        return adapteTimestamp;
    }

    public void setAdapteTimestamp(Long adapteTimestamp) {
        this.adapteTimestamp = adapteTimestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DeviceModel{" +
                "devId='" + devId + '\'' +
                ", iccid='" + iccid + '\'' +
                ", adapteTimestamp=" + adapteTimestamp +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
