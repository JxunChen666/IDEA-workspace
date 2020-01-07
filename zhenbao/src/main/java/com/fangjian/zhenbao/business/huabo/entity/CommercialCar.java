package com.fangjian.zhenbao.business.huabo.entity;

public class CommercialCar {
    private Long id;

    private String brandFirstLetter;

    private String brand;

    private String modelName;

    private String engineName;

    private String productType;

    private String fuelType;

    private String emissionStandard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandFirstLetter() {
        return brandFirstLetter;
    }

    public void setBrandFirstLetter(String brandFirstLetter) {
        this.brandFirstLetter = brandFirstLetter == null ? null : brandFirstLetter.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName == null ? null : engineName.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType == null ? null : fuelType.trim();
    }

    public String getEmissionStandard() {
        return emissionStandard;
    }

    public void setEmissionStandard(String emissionStandard) {
        this.emissionStandard = emissionStandard == null ? null : emissionStandard.trim();
    }
}