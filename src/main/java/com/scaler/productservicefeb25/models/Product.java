package com.scaler.productservicefeb25.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private Category category;
}
