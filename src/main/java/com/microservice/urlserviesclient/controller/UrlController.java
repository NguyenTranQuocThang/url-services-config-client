package com.microservice.urlserviesclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
    @Value("${base-url}")
    private String baseUrl;

    @GetMapping(path = "/url")
    public ResponseEntity<?> getUrl(){
        return ResponseEntity.ok().body(baseUrl);
    }
}
