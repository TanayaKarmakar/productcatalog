package com.app.product.productcatalog.services;

import com.app.product.productcatalog.models.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(String id);

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO deleteProductById(String id);

    ProductDTO updateProductById(String id, ProductDTO productDTO);
}
