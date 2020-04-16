package com.example.ProductMerge.service;

import com.example.ProductMerge.Entity.ProductPricingEntity;
import com.example.ProductMerge.repository.ProductCatelogRepo;
import com.example.ProductMerge.repository.ProductPricingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductPricingService {

    @Autowired
    ProductPricingRepo productPricingRepo;
    @Autowired
    ProductInventoryService productInventoryService;

    public String getPrice(int product_id, int quantity_required) {
        ProductPricingEntity productPricingEntity = productPricingRepo.findById(product_id).orElseThrow(() -> new ResourceNotFoundException());
        Integer priceOfAProduct = productPricingEntity.getCost_per_product();
        Integer availability = productInventoryService.getQuantityAvailable(product_id);
        if (availability >= quantity_required) {
            String str = "priceOfAProduct * quantity_required = " + priceOfAProduct * quantity_required;
            return str;
        } else {
            String s = "AvailableQuantity is = " + availability;
            return s;
        }
    }

    public void setProductCostPerUnit(int product_id, int price_of_a_product) {
        ProductPricingEntity productPricingEntity = productPricingRepo.findById(product_id).orElseThrow(() -> new ResourceNotFoundException());
        productPricingEntity.setCost_per_product(price_of_a_product);
    }
}
