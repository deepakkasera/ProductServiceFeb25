package com.scaler.productservicefeb25.services;

import com.scaler.productservicefeb25.dtos.FakeStoreProductDto;
import com.scaler.productservicefeb25.models.Category;
import com.scaler.productservicefeb25.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    //This Service implementation uses FakeStore to fetch products from FakeStore.
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product getProductById(Long productId) {
        // Make a API call to FakeStore and get the product with the given Id.
        // https://fakestoreapi.com/products/10

        throw new RuntimeException("Something went wrong");

//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/" + productId,
//                FakeStoreProductDto.class);
//
//        //Convert FakeStoreProductDto object into a Product object.
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }
}
