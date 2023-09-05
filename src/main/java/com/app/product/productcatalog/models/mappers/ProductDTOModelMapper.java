package com.app.product.productcatalog.models.mappers;

import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Category;
import com.app.product.productcatalog.models.entities.Product;

public class ProductDTOModelMapper {
    public static Product toProduct(ProductDTO productDTO) {
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
}
