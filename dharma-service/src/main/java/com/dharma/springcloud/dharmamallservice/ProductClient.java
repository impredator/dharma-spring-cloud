package com.dharma.springcloud.dharmamallservice;

import com.dharma.springcloud.dharmamallservice.beans.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product", url = "http://localhost:8011")
public interface ProductClient {
    @GetMapping(value = "/product/{id}", produces = "application/json")
    Product getProductById(@PathVariable("id") int id);
}
