package com.fangjian.zhenbao.business.huabo.entity;

import java.math.BigDecimal;

public class BaseUser {
    private Integer userId;

    private String userName;

    private String userTruename;

    private String userAvatar;

    private Boolean userSex;

    private String userPassword;

    private String userMobile;

    private String roleName;

    private BigDecimal redCash;

    private Byte isValid;

    private String recommendCode;

    private String beRecommendCode;

    private Integer recommendCount;

    private String idFront;

    private String idOpposite;

    private String idNumber;

    private String payPassword;

    private Byte realNameState;

    private Integer serviceId;

    private String accessToken;

    private String authToken;

    private Long sequence;

    private Integer customer;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserTruename() {
        return userTruename;
    }

    public void setUserTruename(String userTruename) {
        this.userTruename = userTruename == null ? null : userTruename.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public BigDecimal getRedCash() {
        return redCash;
    }

    public void setRedCash(BigDecimal redCash) {
        this.redCash = redCash;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode == null ? null : recommendCode.trim();
    }

    public String getBeRecommendCode() {
        return beRecommendCode;
    }

    public void setBeRecommendCode(String beRecommendCode) {
        this.beRecommendCode = beRecommendCode == null ? null : beRecommendCode.trim();
    }

    public Integer getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
    }

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront == null ? null : idFront.trim();
    }

    public String getIdOpposite() {
        return idOpposite;
    }

    public void setIdOpposite(String idOpposite) {
        this.idOpposite = idOpposite == null ? null : idOpposite.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public Byte getRealNameState() {
        return realNameState;
    }

    public void setRealNameState(Byte realNameState) {
        this.realNameState = realNameState;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken == null ? null : authToken.trim();
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }
}