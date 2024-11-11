package com.radol.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.SalesCategoryDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.Item;
import com.radol.model.ItemSalesCategory;
import com.radol.model.SalesCategory;
import com.radol.repository.ItemRepository;
import com.radol.repository.ItemSalesCategoryRepository;
import com.radol.repository.SalesCategoryRepository;
import com.radol.service.SalesCategoryService;

@Service
public class SalesCategoryServiceImpl implements SalesCategoryService {

    private final SalesCategoryRepository salesCategoryRepository;
    private final ItemRepository itemRepository;
    private final ItemSalesCategoryRepository itemSalesCategoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SalesCategoryServiceImpl(SalesCategoryRepository salesCategoryRepository, ItemRepository itemRepository, ItemSalesCategoryRepository itemSalesCategoryRepository, ModelMapper modelMapper) {
        this.salesCategoryRepository = salesCategoryRepository;
        this.itemRepository = itemRepository;
        this.itemSalesCategoryRepository = itemSalesCategoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SalesCategoryDTO createSalesCategory(SalesCategoryDTO salesCategoryDTO) {
        SalesCategory salesCategory = modelMapper.map(salesCategoryDTO, SalesCategory.class);

        // Save sales category
        SalesCategory savedSalesCategory = salesCategoryRepository.save(salesCategory);

        // Establish relationships with items if provided
        if (salesCategoryDTO.getItemSalesCategories() != null && salesCategoryDTO.getItemSalesCategories().isEmpty()) {
            Set<Item> items = itemRepository.findAllById(salesCategoryDTO.getItemSalesCategories()).stream().collect(Collectors.toSet());
            for (Item item : items) {
                ItemSalesCategory itemSalesCategory = new ItemSalesCategory();
                itemSalesCategory.setMappedItemSales(item);
                itemSalesCategory.setMappedSalesCategory(savedSalesCategory);
                itemSalesCategoryRepository.save(itemSalesCategory);
            }
        }

        return modelMapper.map(savedSalesCategory, SalesCategoryDTO.class);
    }

    @Override
    public SalesCategoryDTO getSalesCategoryById(Integer salesCategoryId) {
        SalesCategory salesCategory = salesCategoryRepository.findById(salesCategoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Sales Category not found"));
        return modelMapper.map(salesCategory, SalesCategoryDTO.class);
    }

    @Override
    public List<SalesCategoryDTO> getAllSalesCategories() {
        return salesCategoryRepository.findAll().stream()
            .map(salesCategory -> modelMapper.map(salesCategory, SalesCategoryDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public SalesCategoryDTO updateSalesCategory(Integer salesCategoryId, SalesCategoryDTO salesCategoryDTO) {
        SalesCategory existingSalesCategory = salesCategoryRepository.findById(salesCategoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Sales Category not found"));

        // Update fields from DTO
        existingSalesCategory.setSalesCategoryName(salesCategoryDTO.getSalesCategoryName());
        existingSalesCategory.setSalesCategoryMeasurementType(salesCategoryDTO.getSalesCategoryMeasurementType());
        existingSalesCategory.setSalesCategorySystemMeasurement(salesCategoryDTO.getSalesCategorySystemMeasurement());

        // Update related items
        if (salesCategoryDTO.getItemSalesCategories() != null) {
            // Remove existing relationships
            itemSalesCategoryRepository.deleteAllByMappedSalesCategory(existingSalesCategory);

            // Add new relationships
            Set<Item> items = itemRepository.findAllById(salesCategoryDTO.getItemSalesCategories()).stream().collect(Collectors.toSet());
            for (Item item : items) {
                ItemSalesCategory itemSalesCategory = new ItemSalesCategory();
                itemSalesCategory.setMappedItemSales(item);
                itemSalesCategory.setMappedSalesCategory(existingSalesCategory);
                itemSalesCategoryRepository.save(itemSalesCategory);
            }
        }

        SalesCategory updatedSalesCategory = salesCategoryRepository.save(existingSalesCategory);
        return modelMapper.map(updatedSalesCategory, SalesCategoryDTO.class);
    }

    @Override
    public void deleteSalesCategory(Integer salesCategoryId) {
        SalesCategory salesCategory = salesCategoryRepository.findById(salesCategoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Sales Category not found"));
        
        // Remove all relationships for this sales category
        itemSalesCategoryRepository.deleteAllByMappedSalesCategory(salesCategory);

        // Delete the sales category
        salesCategoryRepository.delete(salesCategory);
    }
}
