package com.trungphap.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungphap.backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category , Long> {
    
}
