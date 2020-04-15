package com.example.ProductMerge.controller;

import com.example.ProductMerge.Entity.ProductCatalogEntity;
import com.example.ProductMerge.Entity.ProductInventoryEntity;
import com.example.ProductMerge.repository.ProductCatelogRepo;
import com.example.ProductMerge.service.ProductCatalogService;
import com.example.ProductMerge.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addproductinventory/{product_name}/{product_quantity_purchased}")
    private String saveProductInventory(@PathVariable(value = "product_name") String product_name ,
                                        @PathVariable(value = "product_quantity_purchased") int product_quantity_purchased) {

            return productInventoryService.saveProductInventoryDetails(product_name, product_quantity_purchased);








        /*productInventoryService.saveProductInventoryDetails(productEntity);
        return ("Added Successfully");*/
    }


    /*@PutMapping("/update/{product_name}")
    public void saveProductInventoryDetails(@PathVariable(value = "product_name") String product_name){

    }
*/

}
