package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productId);

    List<Product> getAllProducts();
}
