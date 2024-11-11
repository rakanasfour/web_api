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

import com.radol.dto.ComplianceCategoryDTO;
import com.radol.service.ComplianceCategoryService;

@RestController
@RequestMapping("/api/compliance-categories")
public class ComplianceCategoryController {

    private final ComplianceCategoryService complianceCategoryService;

    @Autowired
    public ComplianceCategoryController(ComplianceCategoryService complianceCategoryService) {
        this.complianceCategoryService = complianceCategoryService;
    }

    @PostMapping
    public ResponseEntity<ComplianceCategoryDTO> createComplianceCategory(@RequestBody ComplianceCategoryDTO complianceCategoryDTO) {
        ComplianceCategoryDTO createdCategory = complianceCategoryService.createComplianceCategory(complianceCategoryDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{complianceCategoryId}")
    public ResponseEntity<ComplianceCategoryDTO> getComplianceCategoryById(@PathVariable Integer complianceCategoryId) {
        ComplianceCategoryDTO category = complianceCategoryService.getComplianceCategoryById(complianceCategoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ComplianceCategoryDTO>> getAllComplianceCategories() {
        List<ComplianceCategoryDTO> categories = complianceCategoryService.getAllComplianceCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/{complianceCategoryId}")
    public ResponseEntity<ComplianceCategoryDTO> updateComplianceCategory(@PathVariable Integer complianceCategoryId, @RequestBody ComplianceCategoryDTO complianceCategoryDTO) {
        ComplianceCategoryDTO updatedCategory = complianceCategoryService.updateComplianceCategory(complianceCategoryId, complianceCategoryDTO);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{complianceCategoryId}")
    public ResponseEntity<Void> deleteComplianceCategory(@PathVariable Integer complianceCategoryId) {
        complianceCategoryService.deleteComplianceCategory(complianceCategoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}