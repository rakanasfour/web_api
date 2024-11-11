package com.radol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "brand_pictures")
public class BrandPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_picture_id", columnDefinition = "INT UNSIGNED")
    private Integer brandPictureId;

    @Column(name = "brand_picture_name", length = 300)
    private String brandPictureName;

    @Column(name = "brand_picture_link", length = 300, nullable = false, unique = true)
    private String brandPictureLink;

    // Many-to-one relationship with Brand
    @ManyToOne
    @JoinColumn(name = "b_p_brand_id", referencedColumnName = "brand_id", nullable = false)
    private Brand brand;

    // Getters and Setters

    public Integer getBrandPictureId() {
        return brandPictureId;
    }

    public void setBrandPictureId(Integer brandPictureId) {
        this.brandPictureId = brandPictureId;
    }

    public String getBrandPictureName() {
        return brandPictureName;
    }

    public void setBrandPictureName(String brandPictureName) {
        this.brandPictureName = brandPictureName;
    }

    public String getBrandPictureLink() {
        return brandPictureLink;
    }

    public void setBrandPictureLink(String brandPictureLink) {
        this.brandPictureLink = brandPictureLink;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
