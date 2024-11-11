package com.radol.dto;

public class ItemSalesCategoriesDTO {

    private Integer itemSalesCategoryId;
    private Integer itemId;             // To hold the ID of the associated item
    private Integer salesCategoryId;    // To hold the ID of the associated sales category

    // Getters and Setters
    
    
    

    public Integer getItemSalesCategoryId() {
        return itemSalesCategoryId;
    }

    public ItemSalesCategoriesDTO(Integer itemSalesCategoryId, Integer itemId, Integer salesCategoryId) {
		super();
		this.itemSalesCategoryId = itemSalesCategoryId;
		this.itemId = itemId;
		this.salesCategoryId = salesCategoryId;
	}

    
	public ItemSalesCategoriesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setItemSalesCategoryId(Integer itemSalesCategoryId) {
        this.itemSalesCategoryId = itemSalesCategoryId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSalesCategoryId() {
        return salesCategoryId;
    }

    public void setSalesCategoryId(Integer salesCategoryId) {
        this.salesCategoryId = salesCategoryId;
    }
}
