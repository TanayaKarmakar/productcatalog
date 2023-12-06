package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.models.mappers.ModelMapper;
import com.app.product.productcatalog.repositories.ProductRepository;
import com.app.product.productcatalog.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductDTO> searchProducts(String query, Pageable pageable) {
        Page<Product> productPage = productRepository.findAllByTitleContaining(query, pageable);
        List<Product> productList = productPage.get().toList();
        List<ProductDTO> productDTOList = productList.stream()
                .map(ModelMapper::toProductDTO).toList();


        Page<ProductDTO> productDTOPage = new PageImpl<>(
                productDTOList,
                productPage.getPageable(),
                productPage.getTotalPages());
        
        return productDTOPage;
    }
}
