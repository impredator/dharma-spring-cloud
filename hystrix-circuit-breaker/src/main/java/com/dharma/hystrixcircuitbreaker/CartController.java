package com.dharma.hystrixcircuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    ProductServiceDelegate productServiceDelegate;

    @GetMapping("/product/{id}")
    public String getStudents(@PathVariable String id) {
        System.out.println("Delegating to product service");
        return productServiceDelegate.getProductService(id);
    }
}
