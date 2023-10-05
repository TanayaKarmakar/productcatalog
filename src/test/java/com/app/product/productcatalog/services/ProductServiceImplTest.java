package com.app.product.productcatalog.services;

import com.app.product.productcatalog.ProductCatalogTestUtil;
import com.app.product.productcatalog.ProductCatelogConstants;
import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.ProductDTO;
import com.app.product.productcatalog.models.entities.Product;
import com.app.product.productcatalog.repositories.ProductRepository;
import com.app.product.productcatalog.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private ProductServiceImpl productService;

    private final String productId = "4e36f4c4-40f3-4b91-89b8-923635b16ddf";

    private ProductDTO productDTO;

    private Product product;

    private ProductDTO existingProductDTO;

    @BeforeEach
    public void setUp() throws Exception {
        productDTO = ProductCatalogTestUtil.getInstance(ProductCatelogConstants.PRODUCT_DTO_NEW, ProductDTO.class);
        product = ProductCatalogTestUtil.getInstance(ProductCatelogConstants.PRODUCT_MODEL_EXISTING, Product.class);
        existingProductDTO = ProductCatalogTestUtil.getInstance(ProductCatelogConstants.PRODUCT_DTO_EXISTING, ProductDTO.class);
    }

    @Test
    public void testGetProductByIdSuccess() {
        findById();
        ProductDTO existingProductDTO = productService.getProductById(productId);
        Assertions.assertNotNull(existingProductDTO);
        Assertions.assertEquals(productId, existingProductDTO.getId());
    }

    @Test
    public void testGetProductByIdNotFound() {
        Throwable thrown = assertThrows(NotFoundException.class, () -> productService.getProductById(productId));
        String expectedMessage = "Product with ID " + productId + " doesn't exist";
        Assertions.assertEquals(expectedMessage, thrown.getMessage());
    }

    @Test
    public void testCreateProductSuccess() {
        when(productRepository.save(any())).thenReturn(product);
        ProductDTO createdProductDTO = productService.createProduct(productDTO);
        Assertions.assertNotNull(createdProductDTO);
        Assertions.assertNotNull(createdProductDTO.getId());
    }

    @Test
    public void testDeleteProductByIdSuccess() {
        findById();
        doNothing().when(productRepository).delete(product);
        ProductDTO existingProductDTO = productService.deleteProductById(productId);
        Assertions.assertNotNull(existingProductDTO);
    }

    @Test
    public void testDeleteProductByIdNotFound() {
        testGetProductByIdNotFound();
    }

    @Test
    public void testUpdateProductSuccess() throws Exception {
        findById();
        Product updatedProduct = ProductCatalogTestUtil.getInstance(ProductCatelogConstants.PRODUCT_MODEL_UPDATE, Product.class);
        ProductDTO productUpdateRequest =
                ProductCatalogTestUtil.getInstance(ProductCatelogConstants.PRODUCT_DTO_UPDATE_REQUEST, ProductDTO.class);
        when(productRepository.save(any())).thenReturn(updatedProduct);
        ProductDTO updatedProductDTO = productService.updateProductById(productId, productUpdateRequest);


        String updatedDescription = "The brand new iPhone, you're gonna love it";
        Assertions.assertEquals(updatedDescription, updatedProductDTO.getDescription());
    }

    @Test
    public void testUpdateProductNotFound() {
        testGetProductByIdNotFound();
    }

    private void findById() {
        Optional<Product> productOptional = Optional.of(product);
        when(productRepository.findById(any())).thenReturn(productOptional);
    }
}
