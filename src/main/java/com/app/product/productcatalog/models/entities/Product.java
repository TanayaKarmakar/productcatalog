package com.app.product.productcatalog.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;


import java.math.BigDecimal;

@Data
@Setter
@Getter
@Entity
@Document(indexName = "productservice")
public class Product extends BaseModel {
    private String title;
    private String description;
    private BigDecimal price;
    private String image;

    @ManyToOne
    private Category category;
}
