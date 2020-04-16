package com.example.ProductMerge.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "product_inventory")
public class ProductInventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_quantity_available")
    private int available;

    @Column(name = "product_purchase_date")
    private Date date;

    @Column(name = "product_quantity_purchased")
    private int purchase;
/*
    @OneToOne
    @MapsId
    private ProductCatalogEntity productCatalogEntity;*/

}
