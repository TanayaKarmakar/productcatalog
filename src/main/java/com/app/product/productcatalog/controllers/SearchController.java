package com.app.product.productcatalog.controllers;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.ProductSearchDTO;
import com.app.product.productcatalog.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
    @Autowired
    private SearchService searchService;


    @PostMapping
    public Page<ProductDTO> searchProducts(@RequestBody ProductSearchDTO productSearchDTO) {
        return searchService.searchProducts(productSearchDTO.getQuery(), PageRequest.of(
                productSearchDTO.getPageNumber(),
                productSearchDTO.getPageSize())
        );
    }
}
