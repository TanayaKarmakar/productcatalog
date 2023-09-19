package com.app.product.productcatalog.controllers;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.services.ProductService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/products")
public class ProductCatalogController {
    private static Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);

    @Resource
    private Map<String, ProductService> productServiceMap;

    @Value("${product.service.implementation}")
    private String productServiceType;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        logger.info("Product retrieval started for all the products");
        return productServiceMap.get(productServiceType).getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") String id) {
        logger.info("Product retrieval for product id: {} started", id);
        return productServiceMap.get(productServiceType).getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(@PathVariable("id") Long id) {
        logger.info("Product deletion with id: {} has started ", id);
        return new ResponseEntity<>(productServiceMap.get(productServiceType).deleteProductById(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        logger.info("Product creation started for the product: {}", productDTO);
        return productServiceMap.get(productServiceType).createProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProductById(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        logger.info("Product update started for product: {} with values: {}", id, productDTO);
        return productServiceMap.get(productServiceType).updateProductById(id, productDTO);
    }
}
