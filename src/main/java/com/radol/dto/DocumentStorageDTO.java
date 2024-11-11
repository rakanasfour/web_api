package com.radol.dto;

public class DocumentStorageDTO {
    private Integer documentStorageId;
    private String documentStorage1;
    private Integer itemId; // Store the Item ID to maintain the relationship
	public DocumentStorageDTO(Integer documentStorageId, String documentStorage1, Integer itemId) {
		super();
		this.documentStorageId = documentStorageId;
		this.documentStorage1 = documentStorage1;
		this.itemId = itemId;
	}
	public DocumentStorageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getDocumentStorageId() {
		return documentStorageId;
	}
	public void setDocumentStorageId(Integer documentStorageId) {
		this.documentStorageId = documentStorageId;
	}
	public String getDocumentStorage1() {
		return documentStorage1;
	}
	public void setDocumentStorage1(String documentStorage1) {
		this.documentStorage1 = documentStorage1;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


    
}