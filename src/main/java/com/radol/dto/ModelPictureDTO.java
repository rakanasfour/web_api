package com.radol.dto;

public class ModelPictureDTO {

    private Integer modelPictureId;
    private String modelPictureName;
    private String modelPictureLink;
    private Integer modelId; // ID of the associated Model
    
	public ModelPictureDTO(Integer modelPictureId, String modelPictureName, String modelPictureLink, Integer modelId) {
		super();
		this.modelPictureId = modelPictureId;
		this.modelPictureName = modelPictureName;
		this.modelPictureLink = modelPictureLink;
		this.modelId = modelId;
	}

	public ModelPictureDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getModelPictureId() {
		return modelPictureId;
	}

	public void setModelPictureId(Integer modelPictureId) {
		this.modelPictureId = modelPictureId;
	}

	public String getModelPictureName() {
		return modelPictureName;
	}

	public void setModelPictureName(String modelPictureName) {
		this.modelPictureName = modelPictureName;
	}

	public String getModelPictureLink() {
		return modelPictureLink;
	}

	public void setModelPictureLink(String modelPictureLink) {
		this.modelPictureLink = modelPictureLink;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	
	
	
	
    
    

   
}
