package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.SalesCategory;

@Repository
public interface SalesCategoryRepository extends JpaRepository<SalesCategory, Integer> {
}
