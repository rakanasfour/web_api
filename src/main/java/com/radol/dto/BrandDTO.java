package com.radol.dto;

import com.radol.model.Brand.BrandStatus;

public class BrandDTO {

    private Integer brandId;
    private String brandName;
    private String brandDescription;
    private BrandStatus brandStatus; // Optional: Use String if you prefer to map directly to enum values
    private Integer manufacturerId; // ID of the associated Manufacturer

    // Getters and Setters

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public BrandStatus getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(BrandStatus brandStatus) {
        this.brandStatus = brandStatus;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
