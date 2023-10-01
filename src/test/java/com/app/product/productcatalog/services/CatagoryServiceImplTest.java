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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        CategoryDTO newCategoryDTO = categoryService.createCategory(categoryDTO);
        Assertions.assertNotNull(newCategoryDTO);
    }

    @Test
    public void testGetCategoryByIdSuccess() {
        findById();
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
        findById();
        doNothing().when(categoryRepository).delete(category);
        CategoryDTO existingCategoryDTO = categoryService.deleteCategoryById(categoryID);
        Assertions.assertNotNull(existingCategoryDTO);
    }

    @Test
    public void testDeleteCategoryByIdNotFound() {
        testCategoryByIdNotFound();
    }

    @Test
    public void testUpdateCategorySuccess() throws Exception {
        findById();
        Category updatedCategory = ProductCatalogTestUtil.getInstance(ProductCatelogConstants.CATEGORY_MODEL_UPDATE, Category.class);
        CategoryDTO categoryUpdateRequest =
                ProductCatalogTestUtil.getInstance(ProductCatelogConstants.CATEGORY_DTO_UPDATE_REQUEST, CategoryDTO.class);
        when(categoryRepository.save(any())).thenReturn(updatedCategory);
        CategoryDTO updatedCategoryDTO = categoryService.updateCategory(categoryID, categoryUpdateRequest);
        String updatedName = "Electronic Gadgets";
        Assertions.assertEquals(updatedName, updatedCategoryDTO.getName());
    }

    @Test
    public void testUpdateCategoryNotFound() {
        testCategoryByIdNotFound();
    }

    private void findById() {
        Optional<Category> categoryOptional = Optional.of(category);
        when(categoryRepository.findById(any())).thenReturn(categoryOptional);
    }


}
