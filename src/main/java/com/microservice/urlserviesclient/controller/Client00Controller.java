package com.microservice.urlserviesclient.controller;

import com.microservice.urlserviesclient.model.Client0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Client00Controller {

    @Value("${base-url}")
    private String baseUrl;
    @Autowired
    private Environment environment;

    @GetMapping("/client00")
    public ResponseEntity<?> getUrl(){
        return ResponseEntity.ok(Client0.builder()
                .dataTransfer(environment.getProperty("base-url"))
                .environment(environment.getProperty("local.server.port"))
                .build());
    }
}
