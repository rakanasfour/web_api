package com.radol.service;

import java.util.List;

import com.radol.dto.BrandDTO;

public interface BrandService {
    BrandDTO createBrand(BrandDTO brandDTO);
    BrandDTO getBrandById(Integer brandId);
    List<BrandDTO> getAllBrands();
    BrandDTO updateBrand(Integer brandId, BrandDTO brandDTO);
    void deleteBrand(Integer brandId);
}