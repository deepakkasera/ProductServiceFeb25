package com.scaler.productservicefeb25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category") // can only be present in OneToMany side.
    private List<Product> products;
}
