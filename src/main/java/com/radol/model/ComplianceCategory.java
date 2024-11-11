package com.radol.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
@Table(name = "compliance_categories")
public class ComplianceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compliance_category_id", columnDefinition = "INT UNSIGNED")
    private Integer complianceCategoryId;

    @Column(name = "compliance_category_name", length = 25)
    private String complianceCategoryName;

    @Column(name = "compliance_categories_code")
    private Integer complianceCategoriesCode;

    @Column(name = "compliance_category_report_required")
    private Boolean complianceCategoryReportRequired;

    @Column(name = "compliance_category_pct_item", length = 25)
    private String complianceCategoryPctItem;
    
    @OneToOne(mappedBy = "complianceCategory")
    private Item item;

	public ComplianceCategory(Integer complianceCategoryId, String complianceCategoryName,
			Integer complianceCategoriesCode, Boolean complianceCategoryReportRequired,
			String complianceCategoryPctItem, Item item) {
		super();
		this.complianceCategoryId = complianceCategoryId;
		this.complianceCategoryName = complianceCategoryName;
		this.complianceCategoriesCode = complianceCategoriesCode;
		this.complianceCategoryReportRequired = complianceCategoryReportRequired;
		this.complianceCategoryPctItem = complianceCategoryPctItem;
		this.item = item;
	}

	public ComplianceCategory() {
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
    
    
    
    

}

