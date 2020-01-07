package com.fangjian.zhenbao.business.huabo.entity;

/**
 * @author FangJian
 * @description: 故障报警
 * @date 2019-06-28 16:08
 */
public class FaultAlert {
    private Long redisAlertTime;
    private String redisAlertAlertName;
    private String carName;
    private String carIdentityCode;
    private String dateTime;

    public Long getRedisAlertTime() {
        return redisAlertTime;
    }

    public void setRedisAlertTime(Long redisAlertTime) {
        this.redisAlertTime = redisAlertTime;
    }

    public String getRedisAlertAlertName() {
        return redisAlertAlertName;
    }

    public void setRedisAlertAlertName(String redisAlertAlertName) {
        this.redisAlertAlertName = redisAlertAlertName;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
