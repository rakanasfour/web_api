package com.radol.dto;

import com.radol.model.Manufacturer.ManufacturerStatus;

public class ManufacturerDTO {

    private Integer manufacturerId;
    private String manufacturerName;
    private String manufacturerDescription;
    private ManufacturerStatus manufacturerStatus; // Optional: Use String if you prefer to map directly to enum values

    // Getters and Setters

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerDescription() {
        return manufacturerDescription;
    }

    public void setManufacturerDescription(String manufacturerDescription) {
        this.manufacturerDescription = manufacturerDescription;
    }

    public ManufacturerStatus getManufacturerStatus() {
        return manufacturerStatus;
    }

    public void setManufacturerStatus(ManufacturerStatus manufacturerStatus) {
        this.manufacturerStatus = manufacturerStatus;
    }
}
