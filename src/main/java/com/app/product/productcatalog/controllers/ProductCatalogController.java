package com.app.product.productcatalog.controllers;

import com.app.product.productcatalog.exceptions.InvalidTokenException;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.security.JwtObject;
import com.app.product.productcatalog.security.TokenValidator;
import com.app.product.productcatalog.services.ProductService;
import com.app.product.productcatalog.util.constants.ErrorCodes;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/products")
public class ProductCatalogController {
    private static Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);

    @Resource
    private Map<String, ProductService> productServiceMap;

    @Value("${product.service.implementation}")
    private String productServiceType;

    @Autowired
    private TokenValidator tokenValidator;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        logger.info("Product retrieval started for all the products");
        return productServiceMap.get(productServiceType).getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(/*@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,*/ @PathVariable("id") String id) {
        logger.info("Product retrieval for product id: {} started", id);
        //Long userTryingToAccess = fetchUserIdFromToken(authToken);
        return productServiceMap.get(productServiceType).getProductById(id, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(/*@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,*/ @PathVariable("id") String id) {
        logger.info("Product deletion with id: {} has started ", id);
        //Long userIdTryingToAccess = fetchUserIdFromToken(authToken);
        return new ResponseEntity<>(productServiceMap.get(productServiceType)
                .deleteProductById(id, null), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        logger.info("Product creation started for the product: {}", productDTO);
        return productServiceMap.get(productServiceType).createProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProductById(/*@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,*/ @PathVariable("id") String id, @RequestBody ProductDTO productDTO) {
        //Long userIdTryingToAccess = fetchUserIdFromToken(authToken);
        return productServiceMap.get(productServiceType).updateProductById(id, productDTO, null);
    }

    private Long fetchUserIdFromToken(String authToken) {
        Optional<JwtObject> tokenObjectOptional;
        JwtObject authTokenObj = null;
        if(authToken != null) {
            tokenObjectOptional = tokenValidator.validateToken(authToken);
            if(tokenObjectOptional.isEmpty()) {
                logger.error("Token object is empty");
                throw new InvalidTokenException(ErrorCodes.INVALID_TOKEN);
            }
            authTokenObj = tokenObjectOptional.get();
            return authTokenObj.getUserId();
        } else {
            logger.error("Invalid auth token");
            throw new InvalidTokenException(ErrorCodes.INVALID_TOKEN);
        }
    }
}
