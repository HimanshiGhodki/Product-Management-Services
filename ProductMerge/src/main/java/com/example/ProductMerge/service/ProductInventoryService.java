package com.example.ProductMerge.service;

import com.example.ProductMerge.Entity.ProductInventoryEntity;
import com.example.ProductMerge.repository.ProductCatelogRepo;
import com.example.ProductMerge.repository.ProductInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductInventoryService {

    @Autowired
    ProductInventoryRepo productInventoryRepoep;
    @Autowired
    ProductCatelogRepo productCatelogRepo;
    @Autowired
    ProductPricingService productPricingService;

    public ProductInventoryService(ProductInventoryRepo productInventoryRepoep, ProductCatelogRepo productCatelogRepo) {
        this.productInventoryRepoep = productInventoryRepoep;
        this.productCatelogRepo = productCatelogRepo;
    }

    public Integer getQuantity(int p_id) {
        ProductInventoryEntity productEntityList = productInventoryRepoep.findById(p_id).orElseThrow(() -> new ResourceNotFoundException());
        System.out.println(productEntityList);
        Integer n2 = productEntityList.getAvailable();
        System.out.println(n2);
        return n2;
    }

    public String saveProductInventoryDetails(String product_name, int product_quantity_purchased, int price_of_a_product) {
        int product_id = getProductIdByProductName(product_name);
        ProductInventoryEntity productInventoryEntity = productInventoryRepoep.findById(product_id).orElseThrow(() -> new ResourceNotFoundException());
        int n = product_quantity_purchased;
        int a = productInventoryEntity.getAvailable();
        Date today = new Date();
        productPricingService.setProductCostPerUnit(product_id, price_of_a_product);
        if (a - n > 0) {
            productInventoryEntity.setAvailable(a - n);
            productInventoryEntity.setPurchase(n);
            productInventoryEntity.setDate(today);
            productInventoryRepoep.save(productInventoryEntity);
            System.out.println("Added successfully");
            return "added Successfully";
        } else {
            return ("Available Quantity is " + a);

        }
    }

    public int getProductIdByProductName(String product_name) {
        return productCatelogRepo.findByProductName(product_name);
    }

    public Integer getQuantityAvailable(int product_id) {
        ProductInventoryEntity productInventoryEntity = productInventoryRepoep.findById(product_id).orElseThrow(() -> new ResourceNotFoundException());
        return productInventoryEntity.getAvailable();

    }
}
