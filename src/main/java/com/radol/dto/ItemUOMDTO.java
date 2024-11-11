package com.radol.dto;


public class ItemUOMDTO {
	 private Integer itemUomId;
	  //  private Integer itemUomQuantity;             
	    private Integer mappedItemUomId;    
	    private Integer mappedUomItemId;
		public ItemUOMDTO(Integer itemUomId, Integer mappedItemUomId, Integer mappedUomItemId) {
			super();
			this.itemUomId = itemUomId;
			this.mappedItemUomId = mappedItemUomId;
			this.mappedUomItemId = mappedUomItemId;
		}
		public ItemUOMDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getItemUomId() {
			return itemUomId;
		}
		public void setItemUomId(Integer itemUomId) {
			this.itemUomId = itemUomId;
		}
		public Integer getMappedItemUomId() {
			return mappedItemUomId;
		}
		public void setMappedItemUomId(Integer mappedItemUomId) {
			this.mappedItemUomId = mappedItemUomId;
		}
		public Integer getMappedUomItemId() {
			return mappedUomItemId;
		}
		public void setMappedUomItemId(Integer mappedUomItemId) {
			this.mappedUomItemId = mappedUomItemId;
		}
	    
	    
	   


	    
	    
	    

}

