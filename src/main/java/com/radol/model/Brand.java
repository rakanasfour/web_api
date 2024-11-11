package com.radol.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", columnDefinition = "INT UNSIGNED")
    private Integer brandId;

    @Column(name = "brand_name", length = 99, nullable = false, unique = true)
    private String brandName;

    @Column(name = "brand_description", length = 300, nullable = false)
    private String brandDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand_status", nullable = false)
    private BrandStatus brandStatus;
    
    public enum BrandStatus {
        AVAILABLE,      // Corrected spelling from "avaiable"
        DISCONTINUED
    }

    @Column(name = "brand_created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp brandCreatedAt;

    @Column(name = "brand_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp brandUpdatedAt;

    // Many-to-one relationship with Manufacturer
    @ManyToOne
    @JoinColumn(name = "brand_manufacturer_id", referencedColumnName = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

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

    public Timestamp getBrandCreatedAt() {
        return brandCreatedAt;
    }

    public void setBrandCreatedAt(Timestamp brandCreatedAt) {
        this.brandCreatedAt = brandCreatedAt;
    }

    public Timestamp getBrandUpdatedAt() {
        return brandUpdatedAt;
    }

    public void setBrandUpdatedAt(Timestamp brandUpdatedAt) {
        this.brandUpdatedAt = brandUpdatedAt;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
