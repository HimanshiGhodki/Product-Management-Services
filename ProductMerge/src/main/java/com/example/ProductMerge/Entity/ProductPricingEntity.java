package com.example.ProductMerge.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_pricing")
public class ProductPricingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;

    @Column(name = "cost_per_product")
    private int cost_per_product;

    @Column(name = "cost_unit")
    private int cost_unit;
/*
    @OneToOne
    @MapsId
    private ProductCatalogEntity productCatalogEntity;*/

}

