package com.radol.dto;

public class ItemPictureDTO {
    private Integer itemPictureId;
    private String itemPictureMain;
    private Integer itemId; // Store the Item ID for the relationship
    
    
	public ItemPictureDTO(Integer itemPictureId, String itemPictureMain, Integer itemId) {
		super();
		this.itemPictureId = itemPictureId;
		this.itemPictureMain = itemPictureMain;
		this.itemId = itemId;
	}


	public ItemPictureDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getItemPictureId() {
		return itemPictureId;
	}


	public void setItemPictureId(Integer itemPictureId) {
		this.itemPictureId = itemPictureId;
	}


	public String getItemPictureMain() {
		return itemPictureMain;
	}


	public void setItemPictureMain(String itemPictureMain) {
		this.itemPictureMain = itemPictureMain;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	

 
}
