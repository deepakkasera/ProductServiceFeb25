package com.scaler.productservicefeb25;

import com.scaler.productservicefeb25.models.Product;
import com.scaler.productservicefeb25.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductServiceFeb25Application {
    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        List<Product> list2 = new ArrayList<>();
//
//        System.out.println(list.getClass());
//        System.out.println(list1.getClass());
//        System.out.println(list2.getClass());
//
//        System.out.println("DEBUG");

        SpringApplication.run(ProductServiceFeb25Application.class, args);
    }
}
