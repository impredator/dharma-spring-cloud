package com.dharma.springcloud.apigateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ProductController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getStudents(@PathVariable int id) {
        System.out.println("Getting Product details for " + id);

        String response = restTemplate.exchange("http://product-service/product/{id}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, id).getBody();

        System.out.println("Response Body " + response);

        return "Product Id -  " + id + " [ Product Details " + response + " ]";
    }

    public String fallbackMethod(int id) {

        return "Fallback response:: No product details available temporarily";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
