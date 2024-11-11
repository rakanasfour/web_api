package com.radol.model;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "uoms")
public class Uom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uom_id" , columnDefinition = "INT UNSIGNED")
    private Integer uomId;

    @Column(name = "uom_type", length = 50, nullable = false)
    private String uomType;

    @Column(name = "uom_level")
    private Integer uomLevel;

    @Column(name = "uom_created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp uomCreatedAt;

    @Column(name = "uom_updated_at", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp uomUpdatedAt;

    @Column(name = "uom_updated_at_by", length = 99)
    private String uomUpdatedAtBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "uom_status", nullable = false, columnDefinition = "ENUM('AVAILABLE', 'NOTAVAILABLE', 'DISCONTINUED') DEFAULT 'AVAILABLE'")
    private UomStatus uomStatus;

    public enum UomStatus {
        AVAILABLE,
        NOTAVAILABLE,
        DISCONTINUED
    }

    @Column(name = "uom_manufacturer_barcode", length = 55)
    private String uomManufacturerBarcode;

    @Column(name = "uom_internal_barcode", length = 55)
    private String uomInternalBarcode;

    // One-to-one relationship with ShippingDimension
    @OneToOne
    @JoinColumn(name = "uom_shipping_dimension_id", referencedColumnName = "shipping_dimension_id", unique = true)
    private ShippingDimension shippingDimension;

    // Many-to-one relationship with Packaging
    @ManyToOne
    @JoinColumn(name = "uom_packaging_id",  referencedColumnName = "packaging_id")
    private Packaging packaging;

    
    
    
    // Many-to-Many relationship with Item through a junction table
    @OneToMany(mappedBy = "mappedUomItem")
    private List<ItemUOM> itemUoms = new ArrayList<>();

    
    
	 @OneToMany(mappedBy="uompicture",cascade= CascadeType.ALL,orphanRemoval =true)
	 private List<UomPicture>uompictures;


	public Uom(Integer uomId, String uomType, Integer uomLevel, Timestamp uomCreatedAt, Timestamp uomUpdatedAt,
			String uomUpdatedAtBy, UomStatus uomStatus, String uomManufacturerBarcode, String uomInternalBarcode,
			ShippingDimension shippingDimension, Packaging packaging, List<ItemUOM> itemUoms,
			List<UomPicture> uompictures) {
		super();
		this.uomId = uomId;
		this.uomType = uomType;
		this.uomLevel = uomLevel;
		this.uomCreatedAt = uomCreatedAt;
		this.uomUpdatedAt = uomUpdatedAt;
		this.uomUpdatedAtBy = uomUpdatedAtBy;
		this.uomStatus = uomStatus;
		this.uomManufacturerBarcode = uomManufacturerBarcode;
		this.uomInternalBarcode = uomInternalBarcode;
		this.shippingDimension = shippingDimension;
		this.packaging = packaging;
		this.itemUoms = itemUoms;
		this.uompictures = uompictures;
	}


	public Uom() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getUomId() {
		return uomId;
	}


	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}


	public String getUomType() {
		return uomType;
	}


	public void setUomType(String uomType) {
		this.uomType = uomType;
	}


	public Integer getUomLevel() {
		return uomLevel;
	}


	public void setUomLevel(Integer uomLevel) {
		this.uomLevel = uomLevel;
	}


	public Timestamp getUomCreatedAt() {
		return uomCreatedAt;
	}


	public void setUomCreatedAt(Timestamp uomCreatedAt) {
		this.uomCreatedAt = uomCreatedAt;
	}


	public Timestamp getUomUpdatedAt() {
		return uomUpdatedAt;
	}


	public void setUomUpdatedAt(Timestamp uomUpdatedAt) {
		this.uomUpdatedAt = uomUpdatedAt;
	}


	public String getUomUpdatedAtBy() {
		return uomUpdatedAtBy;
	}


	public void setUomUpdatedAtBy(String uomUpdatedAtBy) {
		this.uomUpdatedAtBy = uomUpdatedAtBy;
	}


	public UomStatus getUomStatus() {
		return uomStatus;
	}


	public void setUomStatus(UomStatus uomStatus) {
		this.uomStatus = uomStatus;
	}


	public String getUomManufacturerBarcode() {
		return uomManufacturerBarcode;
	}


	public void setUomManufacturerBarcode(String uomManufacturerBarcode) {
		this.uomManufacturerBarcode = uomManufacturerBarcode;
	}


	public String getUomInternalBarcode() {
		return uomInternalBarcode;
	}


	public void setUomInternalBarcode(String uomInternalBarcode) {
		this.uomInternalBarcode = uomInternalBarcode;
	}


	public ShippingDimension getShippingDimension() {
		return shippingDimension;
	}


	public void setShippingDimension(ShippingDimension shippingDimension) {
		this.shippingDimension = shippingDimension;
	}


	public Packaging getPackaging() {
		return packaging;
	}


	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}


	public List<ItemUOM> getItemUoms() {
		return itemUoms;
	}


	public void setItemUoms(List<ItemUOM> itemUoms) {
		this.itemUoms = itemUoms;
	}


	public List<UomPicture> getUompictures() {
		return uompictures;
	}


	public void setUompictures(List<UomPicture> uompictures) {
		this.uompictures = uompictures;
	}


	 
	 
	 
    
}

