package com.fangjian.zhenbao.business.huabo.entity;

public class ServiceStationLine {
    private Long id;

    private Integer codeInner;

    private String codeNumber;

    private String name;

    private Integer stationId;

    private String stationName;

    private String type;

    private String supportMethod;

    private Integer supplierId;

    private String supplier;

    private String camera;

    private String lastQualificationDate;

    private String qualificationValid;

    private String toBeQualificationValid;

    private Integer status;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodeInner() {
        return codeInner;
    }

    public void setCodeInner(Integer codeInner) {
        this.codeInner = codeInner;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber == null ? null : codeNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSupportMethod() {
        return supportMethod;
    }

    public void setSupportMethod(String supportMethod) {
        this.supportMethod = supportMethod == null ? null : supportMethod.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera == null ? null : camera.trim();
    }

    public String getLastQualificationDate() {
        return lastQualificationDate;
    }

    public void setLastQualificationDate(String lastQualificationDate) {
        this.lastQualificationDate = lastQualificationDate == null ? null : lastQualificationDate.trim();
    }

    public String getQualificationValid() {
        return qualificationValid;
    }

    public void setQualificationValid(String qualificationValid) {
        this.qualificationValid = qualificationValid == null ? null : qualificationValid.trim();
    }

    public String getToBeQualificationValid() {
        return toBeQualificationValid;
    }

    public void setToBeQualificationValid(String toBeQualificationValid) {
        this.toBeQualificationValid = toBeQualificationValid == null ? null : toBeQualificationValid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}