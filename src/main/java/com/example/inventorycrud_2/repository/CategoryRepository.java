package com.example.inventorycrud_2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorycrud_2.entity.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
