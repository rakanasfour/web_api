package com.radol.dto;

public class ItemsAttributesDTO {

    private Integer itemAttributeId;
    private Integer itemId;      // To hold the ID of the associated item
    private Integer attributeId;

    public ItemsAttributesDTO(Integer itemAttributeId, Integer itemId, Integer attributeId) {
		super();
		this.itemAttributeId = itemAttributeId;
		this.itemId = itemId;
		this.attributeId = attributeId;
	}

	public ItemsAttributesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemAttributeId() {
		return itemAttributeId;
	}

	public void setItemAttributeId(Integer itemAttributeId) {
		this.itemAttributeId = itemAttributeId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	
    
    
    
    
}
