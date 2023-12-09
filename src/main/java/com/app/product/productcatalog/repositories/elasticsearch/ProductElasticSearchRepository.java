package com.app.product.productcatalog.repositories.elasticsearch;

import com.app.product.productcatalog.models.entities.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface ProductElasticSearchRepository extends ElasticsearchRepository<Product, UUID> {
    List<Product> findAllByTitleContainingOrDescriptionContaining(String query);
}
