package com.radol.service;

import java.util.List;

import com.radol.dto.ManufacturerPricingDTO;

public interface ManufacturerPricingService {
    ManufacturerPricingDTO createPricing(ManufacturerPricingDTO pricingDTO);
    ManufacturerPricingDTO getPricingById(Integer pricingId);
    List<ManufacturerPricingDTO> getAllPricing();
    ManufacturerPricingDTO updatePricing(Integer pricingId, ManufacturerPricingDTO pricingDTO);
    void deletePricing(Integer pricingId);
}