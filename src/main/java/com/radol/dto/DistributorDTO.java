package com.radol.dto;


public class DistributorDTO {

    private Integer distributorId;
    private String distributorName;
    private String distributorAddress;
    private String distributorCountry;
    
    
    
    
	public DistributorDTO(Integer distributorId, String distributorName, String distributorAddress,
			String distributorCountry) {
		super();
		this.distributorId = distributorId;
		this.distributorName = distributorName;
		this.distributorAddress = distributorAddress;
		this.distributorCountry = distributorCountry;
	}
	
	
	public DistributorDTO() {
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
    

  //  private DistributorStatus distributorStatus;
    
    
    





	


    
    
}
