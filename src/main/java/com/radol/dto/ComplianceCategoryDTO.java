package com.radol.dto;

public class ComplianceCategoryDTO {
	
	
    private Integer complianceCategoryId;
    private String complianceCategoryName;
    private Integer complianceCategoriesCode;
    private Boolean complianceCategoryReportRequired;
    private String complianceCategoryPctItem;
    
    
	public ComplianceCategoryDTO(Integer complianceCategoryId, String complianceCategoryName,
			Integer complianceCategoriesCode, Boolean complianceCategoryReportRequired,
			String complianceCategoryPctItem) {
		super();
		this.complianceCategoryId = complianceCategoryId;
		this.complianceCategoryName = complianceCategoryName;
		this.complianceCategoriesCode = complianceCategoriesCode;
		this.complianceCategoryReportRequired = complianceCategoryReportRequired;
		this.complianceCategoryPctItem = complianceCategoryPctItem;
	}


	public ComplianceCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getComplianceCategoryId() {
		return complianceCategoryId;
	}


	public void setComplianceCategoryId(Integer complianceCategoryId) {
		this.complianceCategoryId = complianceCategoryId;
	}


	public String getComplianceCategoryName() {
		return complianceCategoryName;
	}


	public void setComplianceCategoryName(String complianceCategoryName) {
		this.complianceCategoryName = complianceCategoryName;
	}


	public Integer getComplianceCategoriesCode() {
		return complianceCategoriesCode;
	}


	public void setComplianceCategoriesCode(Integer complianceCategoriesCode) {
		this.complianceCategoriesCode = complianceCategoriesCode;
	}


	public Boolean getComplianceCategoryReportRequired() {
		return complianceCategoryReportRequired;
	}


	public void setComplianceCategoryReportRequired(Boolean complianceCategoryReportRequired) {
		this.complianceCategoryReportRequired = complianceCategoryReportRequired;
	}


	public String getComplianceCategoryPctItem() {
		return complianceCategoryPctItem;
	}


	public void setComplianceCategoryPctItem(String complianceCategoryPctItem) {
		this.complianceCategoryPctItem = complianceCategoryPctItem;
	}
	
	
	
    
    
    
    
    
    
    
    
}