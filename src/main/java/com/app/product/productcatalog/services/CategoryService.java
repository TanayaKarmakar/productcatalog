package com.app.product.productcatalog.services;

import com.app.product.productcatalog.models.dtos.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> fetchAllCategories();

    CategoryDTO fetchCategoryById(String id);

    CategoryDTO updateCategory(String id, CategoryDTO categoryDTO);

    CategoryDTO deleteCategoryById(String id);

    List<CategoryDTO> fetchCategoriesByName(String name);
}
