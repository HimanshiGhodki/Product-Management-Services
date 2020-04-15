package com.example.ProductMerge.repository;

import com.example.ProductMerge.Entity.ProductCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatelogRepo extends JpaRepository<ProductCatalogEntity, Integer> {

    @Query(value = "select product_id from product_catalog where product_name = ? ",nativeQuery = true)
    public int findByProductName(String product_name);
}
