package com.app.product.productcatalog.repositories.mysql;

import com.app.product.productcatalog.models.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    //List<Product> getAll(Pageable pageable);

    Page<Product> findAllByTitleContaining(String title, Pageable pageable);
}
