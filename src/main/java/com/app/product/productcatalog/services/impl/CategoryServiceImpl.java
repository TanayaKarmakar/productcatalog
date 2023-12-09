package com.app.product.productcatalog.services.impl;

import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.CategoryDTO;
import com.app.product.productcatalog.models.entities.Category;
import com.app.product.productcatalog.models.mappers.ModelMapper;
import com.app.product.productcatalog.repositories.mysql.CategoryRepository;
import com.app.product.productcatalog.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        logger.info("Creating new category started with values: {}", categoryDTO);
        Category category = ModelMapper.toCategory(categoryDTO);
        categoryRepository.save(category);
        logger.info("Creation of new category finished");
        return ModelMapper.toCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> fetchAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return ModelMapper.toCategoryDTOs(categories);
    }

    @Override
    public CategoryDTO fetchCategoryById(String id) {
        logger.info("Retrieval of category with ID: {} started", id);
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(id));
        if(categoryOptional.isEmpty())
            throw new NotFoundException("Category with ID: " + id + " doesn't exist");
        logger.info("Retrieval of category with ID: {} finished", id);
        return ModelMapper.toCategoryDTO(categoryOptional.get());
    }

    @Override
    public CategoryDTO updateCategory(String id, CategoryDTO categoryDTO) {
        logger.info("UpdateCategory started with ID: {} and values: {}", id, categoryDTO);
        CategoryDTO existingCategory = fetchCategoryById(id);
        existingCategory.setName(categoryDTO.getName());
        Category category = ModelMapper.toCategory(existingCategory);
        categoryRepository.save(category);
        logger.info("Update category finished for the ID: {}", id);
        return existingCategory;
    }

    @Override
    public CategoryDTO deleteCategoryById(String id) {
        logger.info("Deletion of category started with ID: {}", id);
        CategoryDTO categoryDTO = fetchCategoryById(id);
        Category category = ModelMapper.toCategory(categoryDTO);
        categoryRepository.delete(category);
        logger.info("Deletion of category finished with ID: {}", id);
        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> fetchCategoriesByName(String name) {
        logger.info("Retrieval of category started with name: {}", name);
        List<Category> categories = categoryRepository.findAllByNameContaining(name);
        List<CategoryDTO> categoryDTOS = ModelMapper.toCategoryDTOs(categories);
        logger.info("Categories with name containing: {} is : {}", name, categoryDTOS);
        return categoryDTOS;
    }
}
