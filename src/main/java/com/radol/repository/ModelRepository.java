package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    // Custom query methods can be added here if needed
}