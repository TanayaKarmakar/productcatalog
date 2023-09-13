package com.app.product.productcatalog.config;


import com.app.product.productcatalog.services.ProductService;
import com.app.product.productcatalog.services.impl.FakeStoreProductServiceImpl;
import com.app.product.productcatalog.services.impl.ProductServiceImpl;
import com.app.product.productcatalog.util.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductCatalogCoreConfig {
    @Autowired
    private FakeStoreProductServiceImpl fakeStoreProductService;

    @Autowired
    private ProductServiceImpl productService;

    @Bean
    public Map<String, ProductService> productServiceMap() {
        Map<String, ProductService> productServiceMap = new HashMap<>();
        productServiceMap.put(AppConstants.FAKE_STORE_PRODUCT_SERVICE, fakeStoreProductService);
        productServiceMap.put(AppConstants.REPO_PRODUCT_SERVICE, productService);
        return productServiceMap;
    }
}
