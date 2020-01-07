package com.fangjian.zhenbao.business.user.entity;

public class ServiceStation {
    private Integer id;

    private String name;

    private String linkMan;

    private Double lng;

    private Double lat;

    private String linkStyle;

    private String address;

    private String phone;

    private String introduce;

    private String logo;

    private String businessTime;

    private Integer areaId;

    private Integer userId;

    private String aptitude;

    private Byte isAuthentication;

    private Long sequence;

    private String authExplain;

    private Long authTimestamp;

    private String identification;

    private String bankOpen;

    private String bankNumber;

    private String bankName;

    private Double robRate;

    private Integer customer;

    private Integer type;

    private String remark;

    // 用户拥有的角色字符串，为了业务需求字段
    private String roleIdsStr;

    public String getRoleIdsStr() {
        return roleIdsStr;
    }

    public void setRoleIdsStr(String roleIdsStr) {
        this.roleIdsStr = roleIdsStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getLinkStyle() {
        return linkStyle;
    }

    public void setLinkStyle(String linkStyle) {
        this.linkStyle = linkStyle == null ? null : linkStyle.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime == null ? null : businessTime.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude == null ? null : aptitude.trim();
    }

    public Byte getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Byte isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getAuthExplain() {
        return authExplain;
    }

    public void setAuthExplain(String authExplain) {
        this.authExplain = authExplain == null ? null : authExplain.trim();
    }

    public Long getAuthTimestamp() {
        return authTimestamp;
    }

    public void setAuthTimestamp(Long authTimestamp) {
        this.authTimestamp = authTimestamp;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public String getBankOpen() {
        return bankOpen;
    }

    public void setBankOpen(String bankOpen) {
        this.bankOpen = bankOpen == null ? null : bankOpen.trim();
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber == null ? null : bankNumber.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Double getRobRate() {
        return robRate;
    }

    public void setRobRate(Double robRate) {
        this.robRate = robRate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}