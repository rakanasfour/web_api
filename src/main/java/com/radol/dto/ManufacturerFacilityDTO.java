package com.radol.dto;

import com.radol.model.ManufacturerFacility.FacilityStatus;

public class ManufacturerFacilityDTO {

    private Integer facilityId;
    private String facilityName;
    private String facilityCountry;
    private FacilityStatus status; // Optional: Use String if you prefer to map directly to enum values
    private Integer manufacturerId; // ID of the associated Manufacturer

    // Getters and Setters

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityCountry() {
        return facilityCountry;
    }

    public void setFacilityCountry(String facilityCountry) {
        this.facilityCountry = facilityCountry;
    }

    public FacilityStatus getStatus() {
        return status;
    }

    public void setStatus(FacilityStatus status) {
        this.status = status;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
