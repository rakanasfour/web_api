package com.radol.dto;

import java.math.BigDecimal;

public class ShippingDimensionsDTO {

    private Integer shippingDimensionId;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal length;
    private BigDecimal weight;

    // Getters and Setters

    public Integer getShippingDimensionId() {
        return shippingDimensionId;
    }

    public void setShippingDimensionId(Integer shippingDimensionId) {
        this.shippingDimensionId = shippingDimensionId;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
