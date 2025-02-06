package com.scaler.productservicefeb25.controllers;

import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/products/1 => GET
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return null;
    }

    // http://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId,
                                 @RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId,
                                  @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable("id") Long id) {

    }
}
