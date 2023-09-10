package com.app.product.productcatalog.thirdpartyclients.product.fakestore;

import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.thirdparty.FakeStoreProductDTO;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.thirdparty.ThirdPartyProductDTO;
import com.app.product.productcatalog.thirdpartyclients.product.ThirdPartyProductServiceClient;
import com.app.product.productcatalog.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductServiceClient implements ThirdPartyProductServiceClient {
    private static Logger logger = LoggerFactory.getLogger(FakeStoreProductServiceClient.class);
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.products}")
    private String fakeStoreApiPathsProduct;

    @Override
    public ThirdPartyProductDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String finalUrl = StringUtil
                .buildFinalStringWithoutDelims(fakeStoreApiUrl, fakeStoreApiPathsProduct, "/{id}");
        logger.info("Final Url for getProductById: {}", finalUrl);
        ResponseEntity<FakeStoreProductDTO> productDTOResponseEntity = restTemplate.getForEntity(finalUrl, FakeStoreProductDTO.class, id);
        if(Objects.isNull(productDTOResponseEntity.getBody())) {
            throw new NotFoundException("Product with ID " + id + " doesn't exist");
        }
        logger.info("Product DTO response - {}", productDTOResponseEntity.getBody());
        return productDTOResponseEntity.getBody();
    }

    @Override
    public ThirdPartyProductDTO createProduct(ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        logger.info("Request body for new product is : {}", productDTO);
        String finalUrl = StringUtil.buildFinalStringWithoutDelims(fakeStoreApiUrl, fakeStoreApiPathsProduct);
        ResponseEntity<FakeStoreProductDTO> productDTOResponseEntity = restTemplate.postForEntity(finalUrl,
                productDTO, FakeStoreProductDTO.class);
        logger.info("Prduct DTO response - {}", productDTOResponseEntity);
        return productDTOResponseEntity.getBody();
    }

    @Override
    public List<ThirdPartyProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ParameterizedTypeReference<List<FakeStoreProductDTO>> typeReference = new ParameterizedTypeReference<>() {};
        String finalUrl = StringUtil.buildFinalStringWithoutDelims(fakeStoreApiUrl, fakeStoreApiPathsProduct);
        ResponseEntity<List<FakeStoreProductDTO>> listResponseEntity = restTemplate.exchange(finalUrl,
                HttpMethod.GET, null, typeReference);
        logger.info("All the products - {}", listResponseEntity.getBody());
        List<ThirdPartyProductDTO> finalResult = new ArrayList<>();
        listResponseEntity.getBody().forEach(finalResult::add);
        return finalResult;
    }

    @Override
    public ThirdPartyProductDTO deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        logger.info("Product with id: {} needs to be deleted ", id);
        String finalUrl = StringUtil
                .buildFinalStringWithoutDelims(fakeStoreApiUrl, fakeStoreApiPathsProduct, "/"+id.toString());
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = restTemplate
                .exchange(finalUrl, HttpMethod.DELETE, null, FakeStoreProductDTO.class);
        return fakeStoreProductDTOResponseEntity.getBody();
    }

    @Override
    public ThirdPartyProductDTO updateProductById(Long id, ThirdPartyProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        logger.info("Product needs to be updated with id: {}", id);
        String finalUrl = StringUtil
                .buildFinalStringWithoutDelims(fakeStoreApiUrl, fakeStoreApiPathsProduct, "/"+id.toString());;
        FakeStoreProductDTO requestDTO = (FakeStoreProductDTO) productDTO;
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(requestDTO, httpHeaders);
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = restTemplate
                .exchange(finalUrl, HttpMethod.PUT, requestEntity, FakeStoreProductDTO.class);
        return fakeStoreProductDTOResponseEntity.getBody();
    }
}
