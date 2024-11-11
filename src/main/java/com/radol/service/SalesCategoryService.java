package com.radol.service;

import java.util.List;

import com.radol.dto.SalesCategoryDTO;

public interface SalesCategoryService {
    SalesCategoryDTO createSalesCategory(SalesCategoryDTO salesCategoryDTO);
    SalesCategoryDTO getSalesCategoryById(Integer salesCategoryId);
    List<SalesCategoryDTO> getAllSalesCategories();
    SalesCategoryDTO updateSalesCategory(Integer salesCategoryId, SalesCategoryDTO salesCategoryDTO);
    void deleteSalesCategory(Integer salesCategoryId);
}