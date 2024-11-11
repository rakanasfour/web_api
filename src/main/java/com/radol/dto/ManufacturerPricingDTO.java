package com.radol.dto;

import java.math.BigDecimal;

public class ManufacturerPricingDTO {

    private Integer pricingId;
    private BigDecimal pricingList;
    private BigDecimal pricingMsrp;
    private BigDecimal pricingRmap;
    private BigDecimal pricingWholesalePrice;
    private BigDecimal pricingFederalExciseTax;
    private BigDecimal pricingCost;

    // Getters and Setters

    public Integer getPricingId() {
        return pricingId;
    }

    public void setPricingId(Integer pricingId) {
        this.pricingId = pricingId;
    }

    public BigDecimal getPricingList() {
        return pricingList;
    }

    public void setPricingList(BigDecimal pricingList) {
        this.pricingList = pricingList;
    }

    public BigDecimal getPricingMsrp() {
        return pricingMsrp;
    }

    public void setPricingMsrp(BigDecimal pricingMsrp) {
        this.pricingMsrp = pricingMsrp;
    }

    public BigDecimal getPricingRmap() {
        return pricingRmap;
    }

    public void setPricingRmap(BigDecimal pricingRmap) {
        this.pricingRmap = pricingRmap;
    }

    public BigDecimal getPricingWholesalePrice() {
        return pricingWholesalePrice;
    }

    public void setPricingWholesalePrice(BigDecimal pricingWholesalePrice) {
        this.pricingWholesalePrice = pricingWholesalePrice;
    }

    public BigDecimal getPricingFederalExciseTax() {
        return pricingFederalExciseTax;
    }

    public void setPricingFederalExciseTax(BigDecimal pricingFederalExciseTax) {
        this.pricingFederalExciseTax = pricingFederalExciseTax;
    }

    public BigDecimal getPricingCost() {
        return pricingCost;
    }

    public void setPricingCost(BigDecimal pricingCost) {
        this.pricingCost = pricingCost;
    }
}
