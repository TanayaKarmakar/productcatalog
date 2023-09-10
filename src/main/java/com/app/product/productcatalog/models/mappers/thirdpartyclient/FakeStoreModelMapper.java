package com.app.product.productcatalog.models.mappers.thirdpartyclient;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.dtos.thirdparty.FakeStoreProductDTO;
import com.app.product.productcatalog.models.dtos.thirdparty.ThirdPartyProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FakeStoreModelMapper extends ThirdPartyModelMapper {
    @Override
    public ProductDTO toDTOFromThirdPartyProduct(ThirdPartyProductDTO thirdPartyProductDTO) {
        FakeStoreProductDTO fakeStoreProductDTO = (FakeStoreProductDTO) thirdPartyProductDTO;
        if(Objects.isNull(fakeStoreProductDTO))
            return null;
        ProductDTO product = new ProductDTO();
        product.setId(fakeStoreProductDTO.getId());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setCategory(fakeStoreProductDTO.getCategory());
        return product;
    }

    @Override
    public List<ProductDTO> toDTOsFromThirdPartyProduct(List<ThirdPartyProductDTO> thirdPartyProductDTOS) {
        List<FakeStoreProductDTO> fakeStoreProductDTOS = thirdPartyProductDTOS.stream()
                .map(thirdPartyProductDTO -> (FakeStoreProductDTO)thirdPartyProductDTO)
                .collect(Collectors.toList());
        if(fakeStoreProductDTOS == null || fakeStoreProductDTOS.isEmpty())
            return new ArrayList<>();
        return fakeStoreProductDTOS.stream().map(this::toDTOFromThirdPartyProduct)
                .collect(Collectors.toList());
    }

    @Override
    public ThirdPartyProductDTO toThirdPartyDTOFromProduct(ProductDTO productDTO) {
        if(Objects.isNull(productDTO))
            return null;
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(productDTO.getId());
        fakeStoreProductDTO.setImage(productDTO.getImage());
        fakeStoreProductDTO.setTitle(productDTO.getTitle());
        fakeStoreProductDTO.setDescription(productDTO.getDescription());
        fakeStoreProductDTO.setImage(productDTO.getImage());
        fakeStoreProductDTO.setCategory(productDTO.getCategory());
        return fakeStoreProductDTO;
    }
}
