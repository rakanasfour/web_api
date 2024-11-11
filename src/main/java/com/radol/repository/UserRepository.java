package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Additional query methods if needed
}
