package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.FakeStoreProductDTO;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.mappers.ModelMapper;
import com.app.product.productcatalog.services.ProductService;
import com.app.product.productcatalog.util.StringUtil;
import com.app.product.productcatalog.util.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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
    public ProductDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String finalUrl = StringUtil
                .buildFinalString(AppConstants.FORWARD_SLASH, AppConstants.FAKESTORE_PRODUCT_BASE_URL, "{id}");
        logger.info("Final Url for getProductById: {}", finalUrl);
        ResponseEntity<FakeStoreProductDTO> productDTOResponseEntity = restTemplate.getForEntity(finalUrl, FakeStoreProductDTO.class, id);
        if(Objects.isNull(productDTOResponseEntity.getBody())) {
            throw new NotFoundException("Product with ID " + id + " doesn't exist");
        }
        logger.info("Product DTO response - {}", productDTOResponseEntity.getBody());
        return ModelMapper.toDTOFromFakeProduct(productDTOResponseEntity.getBody());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        logger.info("Request body for new product is : {}", productDTO);
        ResponseEntity<FakeStoreProductDTO> productDTOResponseEntity = restTemplate.postForEntity(AppConstants.FAKESTORE_PRODUCT_BASE_URL,
                productDTO, FakeStoreProductDTO.class);
        logger.info("Prduct DTO response - {}", productDTOResponseEntity);
        return ModelMapper.toDTOFromFakeProduct(productDTOResponseEntity.getBody());
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ParameterizedTypeReference<List<FakeStoreProductDTO>> typeReference = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<FakeStoreProductDTO>> listResponseEntity = restTemplate.exchange(AppConstants.FAKESTORE_PRODUCT_BASE_URL,
                HttpMethod.GET, null, typeReference);
        logger.info("All the products - {}", listResponseEntity.getBody());
        return ModelMapper.toDTOsFromFakeProduct(listResponseEntity.getBody());
    }

    @Override
    public ProductDTO deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        logger.info("Product with id: {} needs to be deleted ", id);
        String finalUrl = StringUtil
                .buildFinalString(AppConstants.FORWARD_SLASH, AppConstants.FAKESTORE_PRODUCT_BASE_URL, id.toString());
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = restTemplate
                .exchange(finalUrl, HttpMethod.DELETE, null, FakeStoreProductDTO.class);
        return ModelMapper.toDTOFromFakeProduct(fakeStoreProductDTOResponseEntity.getBody());
    }

    @Override
    public ProductDTO updateProductById(Long id, ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        logger.info("Product needs to be updated with id: {}", id);
        String finalUrl = StringUtil
                .buildFinalString(AppConstants.FORWARD_SLASH, AppConstants.FAKESTORE_PRODUCT_BASE_URL, id.toString());
        FakeStoreProductDTO requestDTO = ModelMapper.toFakeStoreProductDTO(productDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(requestDTO, httpHeaders);
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = restTemplate
                .exchange(finalUrl, HttpMethod.PUT, requestEntity, FakeStoreProductDTO.class);
        return ModelMapper.toDTOFromFakeProduct(fakeStoreProductDTOResponseEntity.getBody());
    }
}
