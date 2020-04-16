package com.example.ProductMerge.controller;

import com.example.ProductMerge.service.ProductPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productpricing")
public class ProductPricingController {

    @Autowired
    ProductPricingService productPricingService;

    @GetMapping("/{product_id}/{quantity_required}")
    public String getProductPriceById(@PathVariable(value = "product_id") int product_id,
                                      @PathVariable(value = "quantity_required") int quantity_required) {
        return productPricingService.getPrice(product_id, quantity_required);
    }
}
