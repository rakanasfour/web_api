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
@Table(name = "uom_pictures")
public class UomPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uom_picture_id" , columnDefinition = "INT UNSIGNED")
    private Integer uomPictureId;

    @Column(name = "uom_picture_name", length = 99)
    private String uomPictureName;

    @Column(name = "uom_picture_link", length = 300)
    private String uomPictureLink;

    // Many-to-one relationship with Uom
    @ManyToOne
    @JoinColumn(name = "uom_picture_uom_id", referencedColumnName = "uom_id", nullable = false)
    private Uom uompicture;

	public UomPicture(Integer uomPictureId, String uomPictureName, String uomPictureLink, Uom uompicture) {
		super();
		this.uomPictureId = uomPictureId;
		this.uomPictureName = uomPictureName;
		this.uomPictureLink = uomPictureLink;
		this.uompicture = uompicture;
	}

	public UomPicture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUomPictureId() {
		return uomPictureId;
	}

	public void setUomPictureId(Integer uomPictureId) {
		this.uomPictureId = uomPictureId;
	}

	public String getUomPictureName() {
		return uomPictureName;
	}

	public void setUomPictureName(String uomPictureName) {
		this.uomPictureName = uomPictureName;
	}

	public String getUomPictureLink() {
		return uomPictureLink;
	}

	public void setUomPictureLink(String uomPictureLink) {
		this.uomPictureLink = uomPictureLink;
	}

	public Uom getUompicture() {
		return uompicture;
	}

	public void setUompicture(Uom uompicture) {
		this.uompicture = uompicture;
	}

    
    
}
