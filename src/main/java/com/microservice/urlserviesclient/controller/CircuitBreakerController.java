package com.microservice.urlserviesclient.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);


    @GetMapping("/sample-api")
    // default retry = 3
//    @Retry(name = "sample-api",fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "default",fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public String sampleApi(){
        logger.info("Sample api call received");
//        var response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);
//        return response.getBody();
        return "Sample API";
    }

    private String hardcodedResponse(Exception ex){
        return "sample-api";
    }
}


