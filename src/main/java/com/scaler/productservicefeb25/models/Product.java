package com.scaler.productservicefeb25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn
    private Category category;
}


/*

xY => x_y

   1            1
Product ==== Category => M:1
  M             1

 */