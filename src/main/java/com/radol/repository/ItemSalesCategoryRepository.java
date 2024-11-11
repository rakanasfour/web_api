package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.ItemSalesCategory;
import com.radol.model.SalesCategory;

import jakarta.transaction.Transactional;

@Repository
public interface ItemSalesCategoryRepository extends JpaRepository<ItemSalesCategory, Integer> {

    @Transactional
    void deleteAllByMappedSalesCategory(SalesCategory mappedSalesCategory);
}
