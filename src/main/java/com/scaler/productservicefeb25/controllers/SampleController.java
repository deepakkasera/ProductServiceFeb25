package com.scaler.productservicefeb25.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // REST + Controller => Http API's + Controller
@RequestMapping("/search")
public class SampleController {

    // http://localhost:8080/random/hello
    @GetMapping("/hello/{numberOfTimes}")
    public String sayHello(@PathVariable("numberOfTimes") int numberOfTimes) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfTimes; i++) {
            sb.append("Hello Class!!");
        }

        return sb.toString();
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye Everyone!!";
    }
}


/*
EndPoint - /orders, /search, /products

http ->  default port = 80
https -> default port = 443

https://www.amazon.com/search?query='iphone'

https://www.amazon.com/orders?id=101

https://www.amazon.com/payments?.....

 */