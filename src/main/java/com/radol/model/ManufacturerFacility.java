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
@Table(name = "manufacturer_facilities")
public class ManufacturerFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_facility_id", columnDefinition = "INT UNSIGNED")
    private Integer facilityId;

    @Column(name = "m_facility_name", length = 250, nullable = false, unique = true)
    private String facilityName;

    @Column(name = "m_facility_country", length = 250, nullable = false)
    private String facilityCountry;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FacilityStatus status;
    
    public enum FacilityStatus {
        ACTIVE,
        INACTIVE
    }

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    // Many-to-one relationship with Manufacturer
    @ManyToOne
    @JoinColumn(name = "m_f_manufacturer_id", referencedColumnName = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
