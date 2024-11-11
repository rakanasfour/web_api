package com.radol.dto;

import java.util.List;

import com.radol.model.Attribute.AttributeType;

public class AttributeDTO {

    private Integer attributeId;
    private String attributeName;
    private AttributeType attributeType;
    private String attributeAssistText;
    private List<ItemsAttributesDTO> itemAttributes; // Assuming you have a DTO for ItemAttribute
    
    
	public AttributeDTO(Integer attributeId, String attributeName, AttributeType attributeType,
			String attributeAssistText, List<ItemsAttributesDTO> itemAttributes) {
		super();
		this.attributeId = attributeId;
		this.attributeName = attributeName;
		this.attributeType = attributeType;
		this.attributeAssistText = attributeAssistText;
		this.itemAttributes = itemAttributes;
	}


	public AttributeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getAttributeId() {
		return attributeId;
	}


	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}


	public String getAttributeName() {
		return attributeName;
	}


	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}


	public AttributeType getAttributeType() {
		return attributeType;
	}


	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}


	public String getAttributeAssistText() {
		return attributeAssistText;
	}


	public void setAttributeAssistText(String attributeAssistText) {
		this.attributeAssistText = attributeAssistText;
	}


	public List<ItemsAttributesDTO> getItemAttributes() {
		return itemAttributes;
	}


	public void setItemAttributes(List<ItemsAttributesDTO> itemAttributes) {
		this.itemAttributes = itemAttributes;
	}
	
	
	
    
    

}


