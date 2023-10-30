package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.thirdparty.FakeStoreProductDTO;
import com.app.product.productcatalog.models.dtos.thirdparty.ThirdPartyProductDTO;
import com.app.product.productcatalog.models.mappers.thirdpartyclient.ThirdPartyModelMapper;
import com.app.product.productcatalog.security.JwtObject;
import com.app.product.productcatalog.services.ProductService;
import com.app.product.productcatalog.thirdpartyclients.product.ThirdPartyProductServiceClient;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FakeStoreProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(FakeStoreProductServiceImpl.class);
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private ThirdPartyProductServiceClient productServiceClient;

    @Resource
    private Map<String, ThirdPartyModelMapper> thirdPartyModelMapperMap;

    @Override
    public ProductDTO getProductById(String id, Long userIdTryingToAccess) {
        ThirdPartyModelMapper thirdPartyModelMapper = thirdPartyModelMapperMap.get(FakeStoreProductDTO.class.getSimpleName());
        return thirdPartyModelMapper.toDTOFromThirdPartyProduct(productServiceClient.getProductById(Long.valueOf(id)));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ThirdPartyModelMapper thirdPartyModelMapper = thirdPartyModelMapperMap.get(FakeStoreProductDTO.class.getSimpleName());
        return thirdPartyModelMapper.toDTOFromThirdPartyProduct(productServiceClient.createProduct(productDTO));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        ThirdPartyModelMapper thirdPartyModelMapper = thirdPartyModelMapperMap.get(FakeStoreProductDTO.class.getSimpleName());

        return thirdPartyModelMapper.toDTOsFromThirdPartyProduct(productServiceClient.getAllProducts());
    }

    @Override
    public ProductDTO deleteProductById(String id, Long userIdTryingToAccess) {
        ThirdPartyModelMapper thirdPartyModelMapper = thirdPartyModelMapperMap.get(FakeStoreProductDTO.class.getSimpleName());
        return thirdPartyModelMapper.toDTOFromThirdPartyProduct(productServiceClient.deleteProductById(Long.valueOf(id)));
    }

    @Override
    public ProductDTO updateProductById(String id, ProductDTO productDTO, Long userIdTryingToAccess) {
        ThirdPartyModelMapper thirdPartyModelMapper = thirdPartyModelMapperMap.get(FakeStoreProductDTO.class.getSimpleName());
        ThirdPartyProductDTO thirdPartyProductDTO = thirdPartyModelMapper.toThirdPartyDTOFromProduct(productDTO);
        return thirdPartyModelMapper.toDTOFromThirdPartyProduct(productServiceClient.updateProductById(Long.valueOf(id), thirdPartyProductDTO));
    }
}
