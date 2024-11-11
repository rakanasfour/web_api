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
@Table(name = "items_attributes")
public class ItemAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_attribute_id")
    private Integer itemAttributeId;

    @ManyToOne
    @JoinColumn(name = "item_a_item_id", nullable = false)
    private Item mappedItem;

    @ManyToOne
    @JoinColumn(name = "item_a_attribute_id", nullable = false)
    private Attribute mappedAttribute;

	public ItemAttribute(Integer itemAttributeId, Item mappedItem, Attribute mappedAttribute) {
		super();
		this.itemAttributeId = itemAttributeId;
		this.mappedItem = mappedItem;
		this.mappedAttribute = mappedAttribute;
	}

	public ItemAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemAttributeId() {
		return itemAttributeId;
	}

	public void setItemAttributeId(Integer itemAttributeId) {
		this.itemAttributeId = itemAttributeId;
	}

	public Item getMappedItem() {
		return mappedItem;
	}

	public void setMappedItem(Item mappedItem) {
		this.mappedItem = mappedItem;
	}

	public Attribute getMappedAttribute() {
		return mappedAttribute;
	}

	public void setMappedAttribute(Attribute mappedAttribute) {
		this.mappedAttribute = mappedAttribute;
	}
    
    
    

   
}
