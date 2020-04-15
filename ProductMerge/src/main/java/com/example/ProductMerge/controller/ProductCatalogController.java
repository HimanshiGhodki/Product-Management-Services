package com.example.ProductMerge.controller;

import com.example.ProductMerge.Entity.ProductCatalogEntity;
import com.example.ProductMerge.repository.ProductCatelogRepo;
import com.example.ProductMerge.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productcatalog")
public class ProductCatalogController {

    @Autowired
    private ProductCatelogRepo productCatelogRepo;
    @Autowired
    private ProductCatalogService productCatalogService;

    public ProductCatalogController(ProductCatelogRepo productCatelogRepo, ProductCatalogService productCatalogService) {
        this.productCatelogRepo = productCatelogRepo;
        this.productCatalogService = productCatalogService;
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductCatalogEntity> getProductById(@PathVariable(value = "product_id") int product_id) throws ResourceNotFoundException {
        ProductCatalogEntity productCatalogEntity = productCatalogService.findById(product_id);
        return ResponseEntity.ok().body(productCatalogEntity);

    }

    @PostMapping("/add")
    private String saveProductCatalog(@RequestBody ProductCatalogEntity productEntity) {
        productCatalogService.saveProductCatalogDetails(productEntity);
        return ("Added Successfully");
    }

}

