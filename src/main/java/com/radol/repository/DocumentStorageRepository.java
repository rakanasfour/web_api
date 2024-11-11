package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.DocumentStorage;

@Repository
public interface DocumentStorageRepository extends JpaRepository<DocumentStorage, Integer> {
    // Custom query methods can be added here if needed
}