package com.scaler.productservicefeb25;

import com.scaler.productservicefeb25.projections.ProductWithTitleAndPrice;
import com.scaler.productservicefeb25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceFeb25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
        List<ProductWithTitleAndPrice> products =
                productRepository.getProductTitleAndPriceSQL("iphone 15 pro", 100000.0);

        for (ProductWithTitleAndPrice product : products) {
            System.out.println(product.getTitle() + " -> " + product.getPrice());
        }
    }

}
