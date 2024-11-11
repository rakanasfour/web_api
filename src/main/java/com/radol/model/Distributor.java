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
@Table(name = "distributors")
public class Distributor {
	


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distributor_id", columnDefinition = "INT UNSIGNED")
    private Integer distributorId;

    @Column(name = "distributor_name", length = 99,  nullable = false,  unique = true)
    private String distributorName;

    @Column(name = "distributor_address", length = 250)
    private String distributorAddress;

    @Column(name = "distributor_country", length = 99)
    private String distributorCountry;
  
    @Column(name = "distributor_created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp distributorCreatedAt;

    @Column(name = "distributor_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp distributorUpdatedAt;



    @Enumerated(EnumType.STRING)
    @Column(name = "distributor_status", nullable = false)
    private DistributorStatus distributorStatus;
    //= DistributorStatus.ACTIVE; // Default value

    
    public enum DistributorStatus {
    	ACTIVE, INACTIVE
    }


	public Distributor(Integer distributorId, String distributorName, String distributorAddress,
			String distributorCountry, Timestamp distributorCreatedAt, Timestamp distributorUpdatedAt,
			DistributorStatus distributorStatus) {
		super();
		this.distributorId = distributorId;
		this.distributorName = distributorName;
		this.distributorAddress = distributorAddress;
		this.distributorCountry = distributorCountry;
		this.distributorCreatedAt = distributorCreatedAt;
		this.distributorUpdatedAt = distributorUpdatedAt;
		this.distributorStatus = distributorStatus;
	}


	public Distributor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getDistributorId() {
		return distributorId;
	}


	public void setDistributorId(Integer distributorId) {
		this.distributorId = distributorId;
	}


	public String getDistributorName() {
		return distributorName;
	}


	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}


	public String getDistributorAddress() {
		return distributorAddress;
	}


	public void setDistributorAddress(String distributorAddress) {
		this.distributorAddress = distributorAddress;
	}


	public String getDistributorCountry() {
		return distributorCountry;
	}


	public void setDistributorCountry(String distributorCountry) {
		this.distributorCountry = distributorCountry;
	}


	public Timestamp getDistributorCreatedAt() {
		return distributorCreatedAt;
	}


	public void setDistributorCreatedAt(Timestamp distributorCreatedAt) {
		this.distributorCreatedAt = distributorCreatedAt;
	}


	public Timestamp getDistributorUpdatedAt() {
		return distributorUpdatedAt;
	}


	public void setDistributorUpdatedAt(Timestamp distributorUpdatedAt) {
		this.distributorUpdatedAt = distributorUpdatedAt;
	}


	public DistributorStatus getDistributorStatus() {
		return distributorStatus;
	}


	public void setDistributorStatus(DistributorStatus distributorStatus) {
		this.distributorStatus = distributorStatus;
	}

    
    
    

    
    
	
    
    
    
}
