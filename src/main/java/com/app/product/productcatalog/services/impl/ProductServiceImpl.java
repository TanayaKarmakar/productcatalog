package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.models.mappers.ModelMapper;
import com.app.product.productcatalog.repositories.ProductRepository;
import com.app.product.productcatalog.services.CategoryService;
import com.app.product.productcatalog.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductDTO getProductById(String id) {
        logger.info("Retrieval of product with ID: {} started", id);
        Optional<Product> productOptional = productRepository.findById(UUID.fromString(id));
        if(productOptional.isEmpty()) {
            throw new NotFoundException("Product with ID " + id + " doesn't exist");
        }
        Product product = productOptional.get();
        logger.info("Retrieval of product with ID: {} finished", id);
        return ModelMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        logger.info("Create product has started with values: {}", productDTO);
        Product product = ModelMapper.toProduct(productDTO);
        productRepository.save(product);
        logger.info("Create product has finished with values: {} and ID: {}", productDTO, product.getId());
        return ModelMapper.toProductDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        logger.info("Retrieval of all the products has started");
        List<Product> products = productRepository.findAll();
        logger.info("Retrieval of all the products has finished");
        return ModelMapper.toProductDTOs(products);
    }

    @Override
    public ProductDTO deleteProductById(String id) {
        logger.info("Deletion of product with ID: {} has started", id);
        ProductDTO productDTO = getProductById(id);
        Product product = ModelMapper.toProduct(productDTO);
        productRepository.delete(product);
        logger.info("Deletion of product with ID: {} has finished", id);
        return productDTO;
    }

    @Override
    public ProductDTO updateProductById(String id, ProductDTO productDTO) {
        logger.info("Updation of product has started with ID: {} and values: {}", id, productDTO);
        ProductDTO existingProductDTO = getProductById(id);
        existingProductDTO.setPrice(productDTO.getPrice());
        existingProductDTO.setDescription(productDTO.getDescription());
        existingProductDTO.setImage(productDTO.getImage());
        existingProductDTO.setTitle(productDTO.getTitle());
        existingProductDTO.getCategory().setName(productDTO.getCategory().getName());
        Product product = ModelMapper.toProduct(existingProductDTO);
        productRepository.save(product);
        logger.info("Updation of product has started with ID: {} and values: {}", id, existingProductDTO);
        return existingProductDTO;
    }
}
