package com.radol.service;

import java.util.List;

import com.radol.dto.ShippingDimensionDTO;

public interface ShippingDimensionService {
    ShippingDimensionDTO createShippingDimension(ShippingDimensionDTO shippingDimensionDTO);
    ShippingDimensionDTO getShippingDimensionById(Integer shippingDimensionId);
    List<ShippingDimensionDTO> getAllShippingDimensions();
    ShippingDimensionDTO updateShippingDimension(Integer shippingDimensionId, ShippingDimensionDTO shippingDimensionDTO);
    void deleteShippingDimension(Integer shippingDimensionId);
}