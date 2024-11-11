package com.radol.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id", columnDefinition = "INT UNSIGNED")
    private Integer modelId;

    @Column(name = "model_name", length = 99)
    private String modelName;

    @Column(name = "model_description", length = 4000)
    private String modelDescription;

    // Many-to-one relationship with Brand
    @ManyToOne
    @JoinColumn(name = "model_brand_id", referencedColumnName = "brand_id", nullable = false)
    private Brand brand;

    // Many-to-one relationship with ManufacturerFacility
    @ManyToOne
    @JoinColumn(name = "model_manufacturer_facility_id", referencedColumnName = "m_facility_id")
    private ManufacturerFacility manufacturerFacility;
    
    @OneToMany(mappedBy="modelPicture",cascade= CascadeType.ALL,orphanRemoval =true)
	 private List<ModelPicture>modelPictures;
    
    

	public Model(Integer modelId, String modelName, String modelDescription, Brand brand,
			ManufacturerFacility manufacturerFacility, List<ModelPicture> modelPictures) {
		super();
		this.modelId = modelId;
		this.modelName = modelName;
		this.modelDescription = modelDescription;
		this.brand = brand;
		this.manufacturerFacility = manufacturerFacility;
		this.modelPictures = modelPictures;
	}



	public Model() {
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



	public Brand getBrand() {
		return brand;
	}



	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	public ManufacturerFacility getManufacturerFacility() {
		return manufacturerFacility;
	}



	public void setManufacturerFacility(ManufacturerFacility manufacturerFacility) {
		this.manufacturerFacility = manufacturerFacility;
	}



	public List<ModelPicture> getModelPictures() {
		return modelPictures;
	}



	public void setModelPictures(List<ModelPicture> modelPictures) {
		this.modelPictures = modelPictures;
	}
	
	

	

    
    

    
}
