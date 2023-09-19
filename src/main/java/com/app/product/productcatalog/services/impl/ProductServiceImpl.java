package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.models.mappers.ModelMapper;
import com.app.product.productcatalog.repositories.ProductRepository;
import com.app.product.productcatalog.services.CategoryService;
import com.app.product.productcatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductDTO getProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(UUID.fromString(id));
        if(productOptional.isEmpty()) {
            throw new NotFoundException("Product with ID " + id + " doesn't exist");
        }
        Product product = productOptional.get();
        return ModelMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ModelMapper.toProduct(productDTO);
        productRepository.save(product);
        return ModelMapper.toProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ModelMapper.toProductDTOs(products);
    }

    @Override
    public ProductDTO deleteProductById(Long id) {
        return null;
    }

    @Override
    public ProductDTO updateProductById(Long id, ProductDTO productDTO) {
        return null;
    }
}
