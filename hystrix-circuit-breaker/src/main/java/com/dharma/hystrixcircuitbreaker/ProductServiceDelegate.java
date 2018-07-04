package com.dharma.hystrixcircuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class ProductServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callProductService_Fallback")
    String getProductService(String id) {

        String response = restTemplate
                .exchange("http://localhost:8011/product/{id}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, id).getBody();

        System.out.println("Response Received at " + new Date());

        return "Product Details " + response + " -  " + new Date();
    }

    @SuppressWarnings("unused")
    private String callProductService_Fallback(String id) {

        System.out.println("Product Service is down!!! fallback route enabled...");

        return "No Response From Product Service at this moment. " +
                " Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
