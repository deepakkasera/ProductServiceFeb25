package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();
}
