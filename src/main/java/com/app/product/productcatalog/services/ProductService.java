package com.app.product.productcatalog.services;

import com.app.product.productcatalog.models.entities.Product;

public interface ProductService {
    Product getProductById(Long id);
}
