package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.models.mappers.ProductDTOModelMapper;
import com.app.product.productcatalog.services.ProductService;
import com.app.product.productcatalog.util.StringUtil;
import com.app.product.productcatalog.util.constants.AppConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String finalUrl = StringUtil
                .buildFinalString(AppConstants.FORWARD_SLASH, AppConstants.FAKESTORE_PRODUCT_BASE_URL, "{id}");
        logger.info("Final Url for getProductById: {}", finalUrl);
        ResponseEntity<ProductDTO> productDTOResponseEntity = restTemplate.getForEntity(finalUrl, ProductDTO.class, id);
        logger.info("Product DTO response - {}", productDTOResponseEntity.getBody());
        return ProductDTOModelMapper.toProduct(Objects.requireNonNull(productDTOResponseEntity.getBody()));
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        logger.info("Request body for new product is : {}", productDTO);
        ResponseEntity<ProductDTO> productDTOResponseEntity = restTemplate.postForEntity(AppConstants.FAKESTORE_PRODUCT_BASE_URL,
                productDTO, ProductDTO.class);
        logger.info("Prduct DTO response - {}", productDTOResponseEntity);
        return ProductDTOModelMapper.toProduct(Objects.requireNonNull(productDTOResponseEntity.getBody()));
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ParameterizedTypeReference<List<ProductDTO>> typeReference = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<ProductDTO>> listResponseEntity = restTemplate.exchange(AppConstants.FAKESTORE_PRODUCT_BASE_URL,
                HttpMethod.GET, null, typeReference);
        logger.info("All the products - {}", listResponseEntity.getBody());
        return ProductDTOModelMapper.toProducts(Objects.requireNonNull(listResponseEntity.getBody()));
    }
}
