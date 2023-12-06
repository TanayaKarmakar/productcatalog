package com.app.product.productcatalog.services;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchService {
    Page<ProductDTO> searchProducts(String query, Pageable pageable);
}
