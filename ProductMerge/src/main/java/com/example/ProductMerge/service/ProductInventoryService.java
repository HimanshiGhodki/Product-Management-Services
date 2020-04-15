package com.example.ProductMerge.service;

import com.example.ProductMerge.Entity.ProductInventoryEntity;
import com.example.ProductMerge.repository.ProductCatelogRepo;
import com.example.ProductMerge.repository.ProductInventoryRepo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryService {

    @Autowired
    ProductInventoryRepo productInventoryRepoep;
    @Autowired
    ProductCatelogRepo productCatelogRepo;

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

    public String saveProductInventoryDetails(String product_name ,int product_quantity_purchased) {
        int product_id = getProductIdByProductName(product_name);
        ProductInventoryEntity productInventoryEntity= productInventoryRepoep.findById(product_id).orElseThrow(() -> new ResourceNotFoundException());
        int n = product_quantity_purchased;
        int a = productInventoryEntity.getAvailable();
        if(a-n > 0) {
            productInventoryEntity.setAvailable(a - n);
            productInventoryEntity.setPurchase(n);
            productInventoryRepoep.save(productInventoryEntity);
            return "Added successfully";
        }
        else{
            String s = "Quantity available is " + n;
            return s;
        }
    }

    public int getProductIdByProductName(String product_name){
        return productCatelogRepo.findByProductName(product_name);
    }
}
