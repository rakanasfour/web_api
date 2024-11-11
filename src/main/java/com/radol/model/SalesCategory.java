package com.radol.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_categories")
public class SalesCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_category_id", columnDefinition = "INT UNSIGNED")
    private Integer salesCategoryId;

    @Column(name = "s_category_name", length = 99, nullable = false)
    private String salesCategoryName;

    @Enumerated(EnumType.STRING)
    @Column(name = "s_category_measurement_type", nullable = false)
    private MeasurementType salesCategoryMeasurementType;

    public enum MeasurementType {
        COUNT,
        WEIGHT,
        VOLUME
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "s_category_system_measurement", nullable = false)
    private SystemMeasurement salesCategorySystemMeasurement;

    public enum SystemMeasurement {
        METRIC,
        IMPERIAL
    }

    // Many-to-Many relationship with Item through a junction table
    @OneToMany(mappedBy = "mappedSalesCategory")
    private List<ItemSalesCategory> itemSalesCategories = new ArrayList<>();

	public SalesCategory(Integer salesCategoryId, String salesCategoryName,
			MeasurementType salesCategoryMeasurementType, SystemMeasurement salesCategorySystemMeasurement,
			List<ItemSalesCategory> itemSalesCategories) {
		super();
		this.salesCategoryId = salesCategoryId;
		this.salesCategoryName = salesCategoryName;
		this.salesCategoryMeasurementType = salesCategoryMeasurementType;
		this.salesCategorySystemMeasurement = salesCategorySystemMeasurement;
		this.itemSalesCategories = itemSalesCategories;
	}

	public SalesCategory() {
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

	public MeasurementType getSalesCategoryMeasurementType() {
		return salesCategoryMeasurementType;
	}

	public void setSalesCategoryMeasurementType(MeasurementType salesCategoryMeasurementType) {
		this.salesCategoryMeasurementType = salesCategoryMeasurementType;
	}

	public SystemMeasurement getSalesCategorySystemMeasurement() {
		return salesCategorySystemMeasurement;
	}

	public void setSalesCategorySystemMeasurement(SystemMeasurement salesCategorySystemMeasurement) {
		this.salesCategorySystemMeasurement = salesCategorySystemMeasurement;
	}

	public List<ItemSalesCategory> getItemSalesCategories() {
		return itemSalesCategories;
	}

	public void setItemSalesCategories(List<ItemSalesCategory> itemSalesCategories) {
		this.itemSalesCategories = itemSalesCategories;
	}
    
    
    

  
}
