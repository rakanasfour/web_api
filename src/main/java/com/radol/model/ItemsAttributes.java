package com.radol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items_attributes")
public class ItemsAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_attribute_id" , columnDefinition = "INT UNSIGNED")
    private Integer itemAttributeId;

    @OneToOne
    @JoinColumn(name = "item_a_item_id", referencedColumnName = "item_id", unique = true)
    private Item item; // Assuming you have an Item entity

    @OneToOne
    @JoinColumn(name = "item_a_attribute_id", referencedColumnName = "attribute_id", unique = true)
    private Attribute attribute; // Assuming you have an Attribute entity

   
    
    

    public ItemsAttributes(Integer itemAttributeId, Item item, Attribute attribute) {
		super();
		this.itemAttributeId = itemAttributeId;
		this.item = item;
		this.attribute = attribute;
	}
    
    

	public ItemsAttributes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getItemAttributeId() {
        return itemAttributeId;
    }

    public void setItemAttributeId(Integer itemAttributeId) {
        this.itemAttributeId = itemAttributeId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
