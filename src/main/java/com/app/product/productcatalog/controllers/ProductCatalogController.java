package com.app.product.productcatalog.controllers;

import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductCatalogController {
    private static Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);
    @Autowired
    private ProductService productService;

    @GetMapping
    public void getAllProducts() {

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        logger.info("Product retrieval for product id: {} started", id);
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }

    @PostMapping
    public String createProduct() {
        return "Created product with ID: " + UUID.randomUUID();
    }

    @PutMapping("/{id}")
    public void updateProductById() {

    }
}
