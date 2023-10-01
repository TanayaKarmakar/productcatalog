package com.app.product.productcatalog.services;

import com.app.product.productcatalog.ProductCatalogTestUtil;
import com.app.product.productcatalog.ProductCatelogConstants;
import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.CategoryDTO;
import com.app.product.productcatalog.models.entities.Category;
import com.app.product.productcatalog.repositories.CategoryRepository;
import com.app.product.productcatalog.services.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CatagoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    private final String categoryID = "9acefcef-856e-43ff-bb30-ed936d4222ff";

    private CategoryDTO categoryDTO;

    private Category category;

    @BeforeEach
    public void setUp() throws Exception {
        categoryDTO = ProductCatalogTestUtil.getInstance(ProductCatelogConstants.CATEGORY_NEW, CategoryDTO.class);
        category = ProductCatalogTestUtil.getInstance(ProductCatelogConstants.CATEGORY_MODEL, Category.class);
    }

    @Test
    public void testCreateCategorySuccess() {
        when(categoryRepository.save(any())).thenReturn(category);
        CategoryDTO existingCategoryDTO = categoryService.createCategory(categoryDTO);
        Assertions.assertNotNull(existingCategoryDTO);
    }

    @Test
    public void testGetCategoryByIdSuccess() {
        Optional<Category> categoryOptional = Optional.of(category);
        doReturn(categoryOptional).when(categoryRepository).findById(any());
        CategoryDTO existingCategoryDTO = categoryService.fetchCategoryById(categoryID);
        Assertions.assertNotNull(existingCategoryDTO);
    }

    @Test
    public void testCategoryByIdNotFound() {
        Throwable thrown = assertThrows(NotFoundException.class, () -> categoryService.fetchCategoryById(categoryID));
        String expectedMessage = "Category with ID: 9acefcef-856e-43ff-bb30-ed936d4222ff doesn't exist";
        Assertions.assertEquals(expectedMessage, thrown.getMessage());
    }

    @Test
    public void testDeleteCategoryByIdSuccess() {
        Optional<Category> categoryOptional = Optional.of(category);
        when(categoryRepository.findById(any())).thenReturn(categoryOptional);
        doNothing().when(categoryRepository).delete(category);
        CategoryDTO existingCategoryDTO = categoryService.deleteCategoryById(categoryID);
        Assertions.assertNotNull(existingCategoryDTO);
    }

    @Test
    public void testDeleteCategoryByIdNotFound() {
        testCategoryByIdNotFound();
    }
}
