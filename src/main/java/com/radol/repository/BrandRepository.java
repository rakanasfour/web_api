package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    // Custom query methods can be added here if needed
}