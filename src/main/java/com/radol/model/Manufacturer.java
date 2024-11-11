package com.radol.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id", columnDefinition = "INT UNSIGNED")
    private Integer manufacturerId;

    @Column(name = "manufacturer_name", length = 99, nullable = false, unique = true)
    private String manufacturerName;

    @Column(name = "manufacturer_description", length = 300, nullable = false)
    private String manufacturerDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "manufacturer_status", nullable = false)
    private ManufacturerStatus manufacturerStatus;
    
    public enum ManufacturerStatus {
        ACTIVE,
        INACTIVE
    }


    @Column(name = "manufacturer_created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp manufacturerCreatedAt;

    @Column(name = "manufacturer_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp manufacturerUpdatedAt;

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

    public Timestamp getManufacturerCreatedAt() {
        return manufacturerCreatedAt;
    }

    public void setManufacturerCreatedAt(Timestamp manufacturerCreatedAt) {
        this.manufacturerCreatedAt = manufacturerCreatedAt;
    }

    public Timestamp getManufacturerUpdatedAt() {
        return manufacturerUpdatedAt;
    }

    public void setManufacturerUpdatedAt(Timestamp manufacturerUpdatedAt) {
        this.manufacturerUpdatedAt = manufacturerUpdatedAt;
    }
}
