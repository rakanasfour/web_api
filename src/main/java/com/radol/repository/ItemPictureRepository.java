package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.ItemPicture;

@Repository
public interface ItemPictureRepository extends JpaRepository<ItemPicture, Integer> {
    // Custom query methods can be added here if needed
}