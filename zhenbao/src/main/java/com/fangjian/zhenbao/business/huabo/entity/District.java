package com.fangjian.zhenbao.business.huabo.entity;

import java.io.Serializable;

public class District implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer disId;

    private Integer disParentId;

    private String disName;

    private String disSimpleName;

    private Byte disLevel;


    public District() {

    }

    public District(Integer disId, Integer disParentId, String disName, String disSimpleName, Byte disLevel) {
        this.disId = disId;
        this.disParentId = disParentId;
        this.disName = disName;
        this.disSimpleName = disSimpleName;
        this.disLevel = disLevel;
    }

    @Override
    public String toString() {
        return "District{" +
                "disId=" + disId +
                ", disParentId=" + disParentId +
                ", disName='" + disName + '\'' +
                ", disSimpleName='" + disSimpleName + '\'' +
                ", disLevel=" + disLevel +
                '}';
    }



    public Integer getDisId() {
        return disId;
    }

    public void setDisId(Integer disId) {
        this.disId = disId;
    }

    public Integer getDisParentId() {
        return disParentId;
    }

    public void setDisParentId(Integer disParentId) {
        this.disParentId = disParentId;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName == null ? null : disName.trim();
    }

    public String getDisSimpleName() {
        return disSimpleName;
    }

    public void setDisSimpleName(String disSimpleName) {
        this.disSimpleName = disSimpleName == null ? null : disSimpleName.trim();
    }

    public Byte getDisLevel() {
        return disLevel;
    }

    public void setDisLevel(Byte disLevel) {
        this.disLevel = disLevel;
    }
}