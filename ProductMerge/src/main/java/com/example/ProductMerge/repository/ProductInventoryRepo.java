package com.example.ProductMerge.repository;

import com.example.ProductMerge.Entity.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepo extends JpaRepository<ProductInventoryEntity, Integer> {
}

