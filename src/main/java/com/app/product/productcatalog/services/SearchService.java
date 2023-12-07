package com.app.product.productcatalog.services;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.ProductSearchDTO;

import org.springframework.data.domain.Page;


public interface SearchService {
    Page<ProductDTO> searchProducts(ProductSearchDTO productSearchDTO);
}
