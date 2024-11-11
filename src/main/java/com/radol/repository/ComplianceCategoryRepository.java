package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.ComplianceCategory;

@Repository
public interface ComplianceCategoryRepository extends JpaRepository<ComplianceCategory, Integer> {
    // Custom query methods can be added here if needed
}