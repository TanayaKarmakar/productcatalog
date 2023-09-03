package com.app.product.productcatalog.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductCatalogController {
    @GetMapping
    public void getAllProducts() {

    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "Got the product with ID " + id;
    }

    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }

    @PostMapping
    public void createProduct() {

    }

    @PutMapping("/{id}")
    public void updateProductById() {

    }
}
