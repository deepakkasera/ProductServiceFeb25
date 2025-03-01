package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.repositories.CategoryRepository;
import com.scaler.productservicefeb25.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        //make a DB call to get the product with given Id.
        //select * from products where id = ?
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist.");
        }

        return optionalProduct.get();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {

        Sort sort = Sort.by("imageUrl").ascending().and(Sort.by("price").ascending());

        return productRepository.findAll(
                PageRequest.of(pageNumber, pageSize, sort)
        );
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        // Before saving the product in DB, we should first check if category is
        // present in the DB or not, if yes then good else we'll have to save the category
        // first in the DB.
        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());

        if (optionalCategory.isEmpty()) {
            //Save the category
            category = categoryRepository.save(category);
        } else {
            category = optionalCategory.get();
        }

        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id: " + id + " doesn't exist.");
        }

        Product productFromDB = productOptional.get();

        productFromDB.setTitle(product.getTitle());
        productFromDB.setImageUrl(product.getImageUrl());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setPrice(product.getPrice());

        Category category = product.getCategory();
        if (category.getId() == null) {
            //Save the category first in the DB.
            category = categoryRepository.save(category);
        }

        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
