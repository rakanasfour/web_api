package com.radol.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.radol.model.Item.ItemStatus;


public class ItemDTO {

    private Integer itemId;
    private String itemName;
    private String itemSku;
    private String itemDescription;
    private String itemType;
    private Integer itemQuantity;
    private String itemAvailability;
    private String itemMsaPromoItem;
    private BigDecimal itemBasePrice;
    private BigDecimal itemWeight;
    private Timestamp itemCreatedAt;
    private Timestamp itemUpdatedAt;
    private String itemUpdatedAtBy;
    private ItemStatus itemStatus;
    private Integer manufacturerPricingId;
    private Integer distributorId;
    private Integer modelId;
    private Integer complianceCategoryId;
    
    private List<ItemsChannelsDTO> itemChannels;
    private List<ItemsAttributesDTO> itemAttributes;
    private List<ItemSalesCategoriesDTO> itemSalesCategories;
    private List<ItemUOMDTO> itemsUoms;
	public ItemDTO(Integer itemId, String itemName, String itemSku, String itemDescription, String itemType,
			Integer itemQuantity, String itemAvailability, String itemMsaPromoItem, BigDecimal itemBasePrice,
			BigDecimal itemWeight, Timestamp itemCreatedAt, Timestamp itemUpdatedAt, String itemUpdatedAtBy,
			ItemStatus itemStatus, Integer manufacturerPricingId, Integer distributorId, Integer modelId,
			Integer complianceCategoryId, List<ItemsChannelsDTO> itemChannels, List<ItemsAttributesDTO> itemAttributes,
			List<ItemSalesCategoriesDTO> itemSalesCategories, List<ItemUOMDTO> itemsUoms) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemSku = itemSku;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemQuantity = itemQuantity;
		this.itemAvailability = itemAvailability;
		this.itemMsaPromoItem = itemMsaPromoItem;
		this.itemBasePrice = itemBasePrice;
		this.itemWeight = itemWeight;
		this.itemCreatedAt = itemCreatedAt;
		this.itemUpdatedAt = itemUpdatedAt;
		this.itemUpdatedAtBy = itemUpdatedAtBy;
		this.itemStatus = itemStatus;
		this.manufacturerPricingId = manufacturerPricingId;
		this.distributorId = distributorId;
		this.modelId = modelId;
		this.complianceCategoryId = complianceCategoryId;
		this.itemChannels = itemChannels;
		this.itemAttributes = itemAttributes;
		this.itemSalesCategories = itemSalesCategories;
		this.itemsUoms = itemsUoms;
	}
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSku() {
		return itemSku;
	}
	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getItemAvailability() {
		return itemAvailability;
	}
	public void setItemAvailability(String itemAvailability) {
		this.itemAvailability = itemAvailability;
	}
	public String getItemMsaPromoItem() {
		return itemMsaPromoItem;
	}
	public void setItemMsaPromoItem(String itemMsaPromoItem) {
		this.itemMsaPromoItem = itemMsaPromoItem;
	}
	public BigDecimal getItemBasePrice() {
		return itemBasePrice;
	}
	public void setItemBasePrice(BigDecimal itemBasePrice) {
		this.itemBasePrice = itemBasePrice;
	}
	public BigDecimal getItemWeight() {
		return itemWeight;
	}
	public void setItemWeight(BigDecimal itemWeight) {
		this.itemWeight = itemWeight;
	}
	public Timestamp getItemCreatedAt() {
		return itemCreatedAt;
	}
	public void setItemCreatedAt(Timestamp itemCreatedAt) {
		this.itemCreatedAt = itemCreatedAt;
	}
	public Timestamp getItemUpdatedAt() {
		return itemUpdatedAt;
	}
	public void setItemUpdatedAt(Timestamp itemUpdatedAt) {
		this.itemUpdatedAt = itemUpdatedAt;
	}
	public String getItemUpdatedAtBy() {
		return itemUpdatedAtBy;
	}
	public void setItemUpdatedAtBy(String itemUpdatedAtBy) {
		this.itemUpdatedAtBy = itemUpdatedAtBy;
	}
	public ItemStatus getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}
	public Integer getManufacturerPricingId() {
		return manufacturerPricingId;
	}
	public void setManufacturerPricingId(Integer manufacturerPricingId) {
		this.manufacturerPricingId = manufacturerPricingId;
	}
	public Integer getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Integer distributorId) {
		this.distributorId = distributorId;
	}
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	public Integer getComplianceCategoryId() {
		return complianceCategoryId;
	}
	public void setComplianceCategoryId(Integer complianceCategoryId) {
		this.complianceCategoryId = complianceCategoryId;
	}
	public List<ItemsChannelsDTO> getItemChannels() {
		return itemChannels;
	}
	public void setItemChannels(List<ItemsChannelsDTO> itemChannels) {
		this.itemChannels = itemChannels;
	}
	public List<ItemsAttributesDTO> getItemAttributes() {
		return itemAttributes;
	}
	public void setItemAttributes(List<ItemsAttributesDTO> itemAttributes) {
		this.itemAttributes = itemAttributes;
	}
	public List<ItemSalesCategoriesDTO> getItemSalesCategories() {
		return itemSalesCategories;
	}
	public void setItemSalesCategories(List<ItemSalesCategoriesDTO> itemSalesCategories) {
		this.itemSalesCategories = itemSalesCategories;
	}
	public List<ItemUOMDTO> getItemsUoms() {
		return itemsUoms;
	}
	public void setItemsUoms(List<ItemUOMDTO> itemsUoms) {
		this.itemsUoms = itemsUoms;
	}
    
	
}

