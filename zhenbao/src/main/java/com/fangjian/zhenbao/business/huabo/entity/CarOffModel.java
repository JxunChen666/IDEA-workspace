package com.fangjian.zhenbao.business.huabo.entity;

/**
 * @author FangJian
 * @description: 长期不在线车辆监控返回model
 * @date 2019-07-10 15:36
 */
public class CarOffModel {
    private String carName;
    private String carIdentityCode;
    private String carDeviceId;
    private String userName;
    private String userTruename;
    private String userMobile;
    private Integer type;
    private Long redisAlertTime;

    //用于查询条件 离线时长
    private Long offTime;
    private String offTimeView;

    //有有参构造必有无参构造
    public CarOffModel(){}

    public CarOffModel(Long offTime, String offTimeView) {
        this.offTime = offTime;
        this.offTimeView = offTimeView;
    }

    public String getOffTimeView() {
        return offTimeView;
    }

    public void setOffTimeView(String offTimeView) {
        this.offTimeView = offTimeView;
    }

    public Long getOffTime() {
        return offTime;
    }

    public void setOffTime(Long offTime) {
        this.offTime = offTime;
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

    public String getCarDeviceId() {
        return carDeviceId;
    }

    public void setCarDeviceId(String carDeviceId) {
        this.carDeviceId = carDeviceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTruename() {
        return userTruename;
    }

    public void setUserTruename(String userTruename) {
        this.userTruename = userTruename;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getRedisAlertTime() {
        return redisAlertTime;
    }

    public void setRedisAlertTime(Long redisAlertTime) {
        this.redisAlertTime = redisAlertTime;
    }
}
