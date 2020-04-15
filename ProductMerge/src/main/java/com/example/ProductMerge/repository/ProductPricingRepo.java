package com.example.ProductMerge.repository;

import com.example.ProductMerge.Entity.ProductPricingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPricingRepo extends JpaRepository<ProductPricingEntity, Integer> {

}
