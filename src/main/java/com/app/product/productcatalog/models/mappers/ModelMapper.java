package com.app.product.productcatalog.models.mappers;

import com.app.product.productcatalog.models.dtos.CategoryDTO;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Category;
import com.app.product.productcatalog.models.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class ModelMapper {
    public static Product toProduct(ProductDTO productDTO) {
        if(Objects.isNull(productDTO))
            return null;
        Product product = new Product();
        product.setId(UUID.fromString(productDTO.getId()));
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

    public static Category toCategory(CategoryDTO categoryDTO) {
        if(Objects.isNull(categoryDTO))
            return null;
        Category category = new Category();
        if(Objects.isNull(categoryDTO.getId())) {
            category.setId(UUID.randomUUID());
        } else {
            category.setId(UUID.fromString(categoryDTO.getId()));
        }
        category.setName(categoryDTO.getName());
        return category;
    }

    public static CategoryDTO toCategoryDTO(Category category) {
        if(Objects.isNull(category))
            return null;
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setId(category.getId().toString());
        return categoryDTO;
    }

    public static List<CategoryDTO> toCategoryDTOs(List<Category> categories) {
        if(Objects.isNull(categories) || categories.isEmpty())
            return new ArrayList<>();
        return categories.stream().map(ModelMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }
}
