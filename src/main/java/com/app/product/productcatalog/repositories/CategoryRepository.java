package com.app.product.productcatalog.repositories;

import com.app.product.productcatalog.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
