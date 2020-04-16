package com.example.ProductMerge.service;

import com.example.ProductMerge.Entity.ProductCatalogEntity;
import com.example.ProductMerge.repository.ProductCatelogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogService {

    @Autowired
    public ProductCatelogRepo productCatelogRepo;

    public ProductCatalogEntity findById(int product_id) {
        ProductCatalogEntity productCatalogEntity = productCatelogRepo.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for id::" + product_id));
        return productCatalogEntity;
    }

    public void saveProductCatalogDetails(ProductCatalogEntity productCatalogEntity) {
        productCatelogRepo.save(productCatalogEntity);
    }

}
