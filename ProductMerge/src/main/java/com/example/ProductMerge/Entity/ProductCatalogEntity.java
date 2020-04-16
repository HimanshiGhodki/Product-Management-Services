package com.example.ProductMerge.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_catalog")
public class ProductCatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_description")
    private String product_description;
    @Column(name = "product_brand")
    private String product_brand;
/*
    @OneToOne(mappedBy = "productCatalogEntity", cascade = CascadeType.ALL)
    private ProductInventoryEntity productInventoryEntity;
    @OneToOne(mappedBy = "productCatalogEntity", cascade = CascadeType.ALL)
    private ProductPricingEntity productPricingEntity;*/
}
