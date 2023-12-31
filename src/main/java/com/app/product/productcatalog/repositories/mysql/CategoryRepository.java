package com.app.product.productcatalog.repositories.mysql;

import com.app.product.productcatalog.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    List<Category> findAllByNameContaining(String name);
}
