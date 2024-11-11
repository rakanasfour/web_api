package com.radol.dto;

import java.util.List;
import java.util.Set;

import com.radol.model.SalesCategory;
import com.radol.model.SalesCategory.MeasurementType;
import com.radol.model.SalesCategory.SystemMeasurement;


public class SalesCategoryDTO {
    private Integer salesCategoryId;
    private String salesCategoryName;
    private SalesCategory.MeasurementType salesCategoryMeasurementType;
    private SalesCategory.SystemMeasurement salesCategorySystemMeasurement;
    private List<ItemSalesCategoriesDTO> itemSalesCategories;
    
    
    
	public SalesCategoryDTO(Integer salesCategoryId, String salesCategoryName,
			MeasurementType salesCategoryMeasurementType, SystemMeasurement salesCategorySystemMeasurement,
			List<ItemSalesCategoriesDTO> itemSalesCategories) {
		super();
		this.salesCategoryId = salesCategoryId;
		this.salesCategoryName = salesCategoryName;
		this.salesCategoryMeasurementType = salesCategoryMeasurementType;
		this.salesCategorySystemMeasurement = salesCategorySystemMeasurement;
		this.itemSalesCategories = itemSalesCategories;
	}

	public SalesCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSalesCategoryId() {
		return salesCategoryId;
	}

	public void setSalesCategoryId(Integer salesCategoryId) {
		this.salesCategoryId = salesCategoryId;
	}

	public String getSalesCategoryName() {
		return salesCategoryName;
	}

	public void setSalesCategoryName(String salesCategoryName) {
		this.salesCategoryName = salesCategoryName;
	}

	public SalesCategory.MeasurementType getSalesCategoryMeasurementType() {
		return salesCategoryMeasurementType;
	}

	public void setSalesCategoryMeasurementType(SalesCategory.MeasurementType salesCategoryMeasurementType) {
		this.salesCategoryMeasurementType = salesCategoryMeasurementType;
	}

	public SalesCategory.SystemMeasurement getSalesCategorySystemMeasurement() {
		return salesCategorySystemMeasurement;
	}

	public void setSalesCategorySystemMeasurement(SalesCategory.SystemMeasurement salesCategorySystemMeasurement) {
		this.salesCategorySystemMeasurement = salesCategorySystemMeasurement;
	}

	public List<ItemSalesCategoriesDTO> getItemSalesCategories() {
		return itemSalesCategories;
	}

	public void setItemSalesCategories(List<ItemSalesCategoriesDTO> itemSalesCategories) {
		this.itemSalesCategories = itemSalesCategories;
	}
    
	
	
	
	
    
	
    
}
