package com.radol.dto;

public class UomPictureDTO {

    private Integer uomPictureId;
    private String uomPictureName;
    private String uomPictureLink;
    private Integer uomId; // Assuming you want to include the UOM ID for reference

    // Getters and Setters
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

    public Integer getUomId() {
        return uomId;
    }

    public void setUomId(Integer uomId) {
        this.uomId = uomId;
    }
}
