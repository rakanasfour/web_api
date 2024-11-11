package com.radol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "model_pictures")
public class ModelPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_picture_id", columnDefinition = "INT UNSIGNED")
    private Integer modelPictureId;

    @Column(name = "m_picture_name", length = 300)
    private String modelPictureName;

    @Column(name = "m_picture_link", length = 300, nullable = false, unique = true)
    private String modelPictureLink;

    // Many-to-one relationship with Model
    @ManyToOne
    @JoinColumn(name = "m_picture_model_id", referencedColumnName = "model_id", nullable = false)
    private Model modelPicture;

	public ModelPicture(Integer modelPictureId, String modelPictureName, String modelPictureLink, Model modelPicture) {
		super();
		this.modelPictureId = modelPictureId;
		this.modelPictureName = modelPictureName;
		this.modelPictureLink = modelPictureLink;
		this.modelPicture = modelPicture;
	}

	public ModelPicture() {
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

	public Model getModelPicture() {
		return modelPicture;
	}

	public void setModelPicture(Model modelPicture) {
		this.modelPicture = modelPicture;
	}

	
    
    
    
}
