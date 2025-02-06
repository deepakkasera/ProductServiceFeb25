package com.scaler.productservicefeb25.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //Note : Name of the class and method doesn't make any difference.
    //Create a Bean of RestTemplate.

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
