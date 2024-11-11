package com.radol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_sales_categories")
public class ItemSalesCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_s_c_id" , columnDefinition = "INT UNSIGNED")
    private Integer itemSalesCategoryId;

    @ManyToOne
    @JoinColumn(name = "item_s_c_item", nullable = false)
    private Item mappedItemSales;

    @ManyToOne
    @JoinColumn(name = "item_s_c_category_id", nullable = false)
    private SalesCategory mappedSalesCategory;

	public ItemSalesCategory(Integer itemSalesCategoryId, Item mappedItemSales, SalesCategory mappedSalesCategory) {
		super();
		this.itemSalesCategoryId = itemSalesCategoryId;
		this.mappedItemSales = mappedItemSales;
		this.mappedSalesCategory = mappedSalesCategory;
	}

	public ItemSalesCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemSalesCategoryId() {
		return itemSalesCategoryId;
	}

	public void setItemSalesCategoryId(Integer itemSalesCategoryId) {
		this.itemSalesCategoryId = itemSalesCategoryId;
	}

	public Item getMappedItemSales() {
		return mappedItemSales;
	}

	public void setMappedItemSales(Item mappedItemSales) {
		this.mappedItemSales = mappedItemSales;
	}

	public SalesCategory getMappedSalesCategory() {
		return mappedSalesCategory;
	}

	public void setMappedSalesCategory(SalesCategory mappedSalesCategory) {
		this.mappedSalesCategory = mappedSalesCategory;
	}

	
    

    
}
