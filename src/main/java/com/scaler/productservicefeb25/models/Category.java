package com.scaler.productservicefeb25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    @Column(nullable = false, unique = true)
    private String name;

//    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
//// can only be present in OneToMany side.
//    private List<Product> products;
}
