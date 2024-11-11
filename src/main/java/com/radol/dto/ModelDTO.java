package com.radol.dto;

import java.util.List;

public class ModelDTO {

    private Integer modelId;
    private String modelName;
    private String modelDescription;
    private Integer brandId; // ID of the associated Brand
    private Integer manufacturerFacilityId; // ID of the associated Manufacturer Facility
    private List<ModelPictureDTO> modelPictures; // List of associated ModelPicture DTOs
    
	public ModelDTO(Integer modelId, String modelName, String modelDescription, Integer brandId,
			Integer manufacturerFacilityId, List<ModelPictureDTO> modelPictures) {
		super();
		this.modelId = modelId;
		this.modelName = modelName;
		this.modelDescription = modelDescription;
		this.brandId = brandId;
		this.manufacturerFacilityId = manufacturerFacilityId;
		this.modelPictures = modelPictures;
	}

	public ModelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getManufacturerFacilityId() {
		return manufacturerFacilityId;
	}

	public void setManufacturerFacilityId(Integer manufacturerFacilityId) {
		this.manufacturerFacilityId = manufacturerFacilityId;
	}

	public List<ModelPictureDTO> getModelPictures() {
		return modelPictures;
	}

	public void setModelPictures(List<ModelPictureDTO> modelPictures) {
		this.modelPictures = modelPictures;
	}
	
	
	

   
    
    
    
}
