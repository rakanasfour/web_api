package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.Attribute;

import jakarta.transaction.Transactional;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
    
	
	
}