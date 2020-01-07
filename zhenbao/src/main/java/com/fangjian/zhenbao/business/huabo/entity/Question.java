package com.fangjian.zhenbao.business.huabo.entity;

public class Question {
    private Integer queId;

    private Integer queUserId;

    private String quePosttime;

    private String linkStyle;

    private Integer customer;

    private String queInfo;

    public Integer getQueId() {
        return queId;
    }

    public void setQueId(Integer queId) {
        this.queId = queId;
    }

    public Integer getQueUserId() {
        return queUserId;
    }

    public void setQueUserId(Integer queUserId) {
        this.queUserId = queUserId;
    }

    public String getQuePosttime() {
        return quePosttime;
    }

    public void setQuePosttime(String quePosttime) {
        this.quePosttime = quePosttime == null ? null : quePosttime.trim();
    }

    public String getLinkStyle() {
        return linkStyle;
    }

    public void setLinkStyle(String linkStyle) {
        this.linkStyle = linkStyle == null ? null : linkStyle.trim();
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public String getQueInfo() {
        return queInfo;
    }

    public void setQueInfo(String queInfo) {
        this.queInfo = queInfo == null ? null : queInfo.trim();
    }
}