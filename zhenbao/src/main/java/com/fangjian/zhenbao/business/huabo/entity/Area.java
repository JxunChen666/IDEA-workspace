package com.fangjian.zhenbao.business.huabo.entity;

public class Area {
    private Integer areaId;

    private String area;

    private Integer areaParentId;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getAreaParentId() {
        return areaParentId;
    }

    public void setAreaParentId(Integer areaParentId) {
        this.areaParentId = areaParentId;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", area='" + area + '\'' +
                ", areaParentId=" + areaParentId +
                '}';
    }
}