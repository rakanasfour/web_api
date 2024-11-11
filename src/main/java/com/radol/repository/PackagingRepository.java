package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.Packaging;

@Repository
public interface PackagingRepository extends JpaRepository<Packaging, Integer> {
}