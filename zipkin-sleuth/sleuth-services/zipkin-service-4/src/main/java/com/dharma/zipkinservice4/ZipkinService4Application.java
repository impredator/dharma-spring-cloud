package com.dharma.zipkinservice4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZipkinService4Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinService4Application.class, args);
    }
}

@RestController
class ZipkinController {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(ZipkinController.class.getName());

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/zipkin4")
    public String zipkinService1() {
        LOG.info("Inside zipkinService 4..");
        return "Hi...";
    }
}
