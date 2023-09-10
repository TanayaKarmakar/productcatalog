package com.app.product.productcatalog.config;

import com.app.product.productcatalog.models.mappers.thirdpartyclient.FakeStoreModelMapper;
import com.app.product.productcatalog.models.mappers.thirdpartyclient.ThirdPartyModelMapper;
import com.app.product.productcatalog.util.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MapperStrategyConfig {
    @Autowired
    private FakeStoreModelMapper fakeStoreModelMapper;

    @Bean
    public Map<String, ThirdPartyModelMapper> thirdPartyModelMapperMap() {
        Map<String, ThirdPartyModelMapper> map = new HashMap<>();
        map.put(AppConstants.FAKE_STORE_PRODUCT_DTO, fakeStoreModelMapper);
        return map;
    }
}
