package com.radol.service;

import java.util.List;

import com.radol.dto.ComplianceCategoryDTO;

public interface ComplianceCategoryService {
    ComplianceCategoryDTO createComplianceCategory(ComplianceCategoryDTO complianceCategoryDTO);
    ComplianceCategoryDTO getComplianceCategoryById(Integer complianceCategoryId);
    List<ComplianceCategoryDTO> getAllComplianceCategories();
    ComplianceCategoryDTO updateComplianceCategory(Integer complianceCategoryId, ComplianceCategoryDTO complianceCategoryDTO);
    void deleteComplianceCategory(Integer complianceCategoryId);
}