package com.example.ProductMerge.controller;

import com.example.ProductMerge.repository.ProductCatelogRepo;
import com.example.ProductMerge.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productinventory")
public class ProductInventoryController {

    @Autowired
    ProductInventoryService productInventoryService;
    @Autowired
    ProductCatelogRepo productCatalogRepo;

    public ProductInventoryController(ProductInventoryService productInventoryService, ProductCatelogRepo productCatalogRepo) {
        this.productInventoryService = productInventoryService;
        this.productCatalogRepo = productCatalogRepo;
    }

    @GetMapping("/getQuantity/{P_Id}")
    public Integer getQuantity(@PathVariable(value = "P_Id") int P_Id) {
        Integer n = productInventoryService.getQuantity(P_Id);
        System.out.println(P_Id);
        System.out.println(n);
        return n;
    }

    @PutMapping("/addproductinventory/{product_name}/{product_quantity_purchased}/{price_of_a_product}")
    private String saveProductInventory(@PathVariable(value = "product_name") String product_name,
                                        @PathVariable(value = "product_quantity_purchased") int product_quantity_purchased,
                                        @PathVariable(value = "price_of_a_product") int price_of_a_product) {

        return productInventoryService.saveProductInventoryDetails(product_name, product_quantity_purchased, price_of_a_product);

    }

}
