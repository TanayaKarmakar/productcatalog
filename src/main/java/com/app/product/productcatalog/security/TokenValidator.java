package com.app.product.productcatalog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public Optional<JwtObject> validateToken(String authToken) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        JwtObject authTokenObj = null;

        if(authToken != null) {
            authTokenObj = new JwtObject();
            return Optional.of(authTokenObj);
        }
        return Optional.empty();
    }
}
