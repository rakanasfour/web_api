package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.ComplianceCategoryDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.ComplianceCategory;
import com.radol.repository.ComplianceCategoryRepository;
import com.radol.service.ComplianceCategoryService;

@Service
public class ComplianceCategoryServiceImpl implements ComplianceCategoryService {

    private final ComplianceCategoryRepository complianceCategoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ComplianceCategoryServiceImpl(ComplianceCategoryRepository complianceCategoryRepository, ModelMapper modelMapper) {
        this.complianceCategoryRepository = complianceCategoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ComplianceCategoryDTO createComplianceCategory(ComplianceCategoryDTO complianceCategoryDTO) {
        ComplianceCategory complianceCategory = modelMapper.map(complianceCategoryDTO, ComplianceCategory.class);
        ComplianceCategory savedComplianceCategory = complianceCategoryRepository.save(complianceCategory);
        return modelMapper.map(savedComplianceCategory, ComplianceCategoryDTO.class);
    }

    @Override
    public ComplianceCategoryDTO getComplianceCategoryById(Integer complianceCategoryId) {
        ComplianceCategory complianceCategory = complianceCategoryRepository.findById(complianceCategoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Compliance Category not found"));
        return modelMapper.map(complianceCategory, ComplianceCategoryDTO.class);
    }

    @Override
    public List<ComplianceCategoryDTO> getAllComplianceCategories() {
        return complianceCategoryRepository.findAll().stream()
            .map(category -> modelMapper.map(category, ComplianceCategoryDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public ComplianceCategoryDTO updateComplianceCategory(Integer complianceCategoryId, ComplianceCategoryDTO complianceCategoryDTO) {
        ComplianceCategory existingCategory = complianceCategoryRepository.findById(complianceCategoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Compliance Category not found"));

        modelMapper.map(complianceCategoryDTO, existingCategory);  // Update fields from DTO
        ComplianceCategory updatedCategory = complianceCategoryRepository.save(existingCategory);
        return modelMapper.map(updatedCategory, ComplianceCategoryDTO.class);
    }

    @Override
    public void deleteComplianceCategory(Integer complianceCategoryId) {
        ComplianceCategory complianceCategory = complianceCategoryRepository.findById(complianceCategoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Compliance Category not found"));
        complianceCategoryRepository.delete(complianceCategory);
    }
}