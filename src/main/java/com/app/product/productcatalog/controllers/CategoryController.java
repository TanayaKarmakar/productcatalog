package com.app.product.productcatalog.controllers;

import com.app.product.productcatalog.models.dtos.CategoryDTO;
import com.app.product.productcatalog.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        logger.info("Creation of category started: {}", categoryDTO);
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping
    public List<CategoryDTO> fetchAllCategories() {
        logger.info("Retrieval of all the category started");
        return categoryService.fetchAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDTO fetchCategoryById(@PathVariable("id") String id) {
        logger.info("Retrieval of category with ID: {} started", id);
        return categoryService.fetchCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable("id") String id, @RequestBody CategoryDTO categoryDTO) {
        logger.info("Updation of category with ID: {} started, values: {}", id, categoryDTO);
        return categoryService.updateCategory(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> deleteCategoryById(@PathVariable("id") String id) {
        logger.info("Deletion of category with ID: {} started", id);
        return new ResponseEntity<>(categoryService.deleteCategoryById(id), HttpStatus.NOT_FOUND);
    }
}
