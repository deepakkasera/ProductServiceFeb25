package com.scaler.productservicefeb25.repositories;

import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long productId);
    //select * from products where id = productId

    @Override
    List<Product> findAll();

    Optional<Product> findByTitleContains(String str);
    // select * from products where title like '%str%'

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);
}
