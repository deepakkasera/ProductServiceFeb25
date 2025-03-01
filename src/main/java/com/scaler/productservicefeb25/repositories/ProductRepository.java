package com.scaler.productservicefeb25.repositories;

import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.projections.ProductWithTitleAndPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long productId);
    //select * from products where id = productId

    @Override
    Page<Product> findAll(Pageable pageable);
    //select * from products;

    Optional<Product> findByTitleContains(String str);
    // select * from products where title like '%str%'

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);

    @Override
    Product save(Product product);

    @Override
    void deleteById(Long aLong);

    //select title, price from products where id = 10;
    //HQL -> Hibernate Query Language
    //Based On the models.
//    @Query("select p.title as title, p.price as price from Product p where p.title = :title and p.price = :price")
//    List<ProductWithTitleAndPrice> getProductTitleAndPrice(String title,Double price);


    //Native Query = SQL Query
    @Query(value = "select p.title, p.price from products p where p.title = :title and p.price = :price", nativeQuery = true)
    List<ProductWithTitleAndPrice> getProductTitleAndPriceSQL(String title, Double price);

    //SQL -> Native Query
}
