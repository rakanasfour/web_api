package com.radol.dto;

public class BrandPictureDTO {

    private Integer brandPictureId;
    private String brandPictureName;
    private String brandPictureLink;
    private Integer brandId; // ID of the associated Brand

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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
