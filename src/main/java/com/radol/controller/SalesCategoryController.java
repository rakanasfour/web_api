package com.radol.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radol.dto.SalesCategoryDTO;
import com.radol.service.SalesCategoryService;

@RestController
@RequestMapping("/api/sales-categories")
public class SalesCategoryController {

    private final SalesCategoryService salesCategoryService;

    @Autowired
    public SalesCategoryController(SalesCategoryService salesCategoryService) {
        this.salesCategoryService = salesCategoryService;
    }

    @PostMapping
    public ResponseEntity<SalesCategoryDTO> createSalesCategory(@RequestBody SalesCategoryDTO salesCategoryDTO) {
        SalesCategoryDTO createdSalesCategory = salesCategoryService.createSalesCategory(salesCategoryDTO);
        return new ResponseEntity<>(createdSalesCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{salesCategoryId}")
    public ResponseEntity<SalesCategoryDTO> getSalesCategoryById(@PathVariable Integer salesCategoryId) {
        SalesCategoryDTO salesCategory = salesCategoryService.getSalesCategoryById(salesCategoryId);
        return new ResponseEntity<>(salesCategory, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SalesCategoryDTO>> getAllSalesCategories() {
        List<SalesCategoryDTO> salesCategories = salesCategoryService.getAllSalesCategories();
        return new ResponseEntity<>(salesCategories, HttpStatus.OK);
    }

    @PutMapping("/{salesCategoryId}")
    public ResponseEntity<SalesCategoryDTO> updateSalesCategory(@PathVariable Integer salesCategoryId, @RequestBody SalesCategoryDTO salesCategoryDTO) {
        SalesCategoryDTO updatedSalesCategory = salesCategoryService.updateSalesCategory(salesCategoryId, salesCategoryDTO);
        return new ResponseEntity<>(updatedSalesCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{salesCategoryId}")
    public ResponseEntity<Void> deleteSalesCategory(@PathVariable Integer salesCategoryId) {
        salesCategoryService.deleteSalesCategory(salesCategoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
