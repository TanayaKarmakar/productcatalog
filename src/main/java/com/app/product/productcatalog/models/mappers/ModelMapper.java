package com.app.product.productcatalog.models.mappers;

import com.app.product.productcatalog.models.dtos.FakeStoreProductDTO;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Category;
import com.app.product.productcatalog.models.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ModelMapper {

    public static FakeStoreProductDTO toFakeStoreProductDTO(ProductDTO productDTO) {
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
    public static ProductDTO toDTOFromFakeProduct(FakeStoreProductDTO fakeStoreProductDTO) {
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

    public static List<ProductDTO> toDTOsFromFakeProduct(List<FakeStoreProductDTO> fakeStoreProductDTOS) {
        if(fakeStoreProductDTOS == null || fakeStoreProductDTOS.isEmpty())
            return new ArrayList<>();
        return fakeStoreProductDTOS.stream().map(ModelMapper::toDTOFromFakeProduct)
                .collect(Collectors.toList());
    }


    public static Product toProduct(ProductDTO productDTO) {
        if(Objects.isNull(productDTO))
            return null;
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setImage(productDTO.getImage());
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());
        return product;
    }

    public static List<Product> toProducts(List<ProductDTO> productDTOs) {
        if(productDTOs == null || productDTOs.isEmpty())
            return new ArrayList<>();
        return productDTOs.stream().map(ModelMapper::toProduct)
                .collect(Collectors.toList());
    }
}
