package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.models.mappers.ProductDTOModelMapper;
import com.app.product.productcatalog.services.ProductService;
import com.app.product.productcatalog.util.StringUtil;
import com.app.product.productcatalog.util.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDTO> productDTOResponseEntity = restTemplate.getForEntity(AppConstants.FAKESTORE_PRODUCT, ProductDTO.class, id);
        logger.info("Product DTO response - {}", productDTOResponseEntity.getBody());
        return ProductDTOModelMapper.toProduct(Objects.requireNonNull(productDTOResponseEntity.getBody()));
    }
}
