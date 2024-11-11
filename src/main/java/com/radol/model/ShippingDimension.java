package com.radol.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping_dimensions")
public class ShippingDimension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_dimension_id", columnDefinition = "INT UNSIGNED")
    private Integer shippingDimensionId;

    @Column(name = "height", precision = 10, scale = 2)
    private BigDecimal height;

    @Column(name = "width", precision = 10, scale = 2)
    private BigDecimal width;

    @Column(name = "length", precision = 10, scale = 2)
    private BigDecimal length;

    @Column(name = "weight", precision = 10, scale = 2)
    private BigDecimal weight;

    // One-to-one relationship with Uom
    @OneToOne(mappedBy = "shippingDimension")
    private Uom uom;

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

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }
}
