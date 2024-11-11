package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.Attribute;
import com.radol.model.ItemAttribute;

import jakarta.transaction.Transactional;

@Repository
public interface ItemAttributeRepository extends JpaRepository<ItemAttribute, Integer> {
   
	@Transactional
    void deleteAllByMappedAttribute(Attribute mappedAttribute);
	
}	
