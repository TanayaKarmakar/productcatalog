package com.app.product.productcatalog.models.dtos;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
public class ProductDTO implements Serializable {
    private String id;
    private String title;
    private BigDecimal price;
    private String image;
    private String description;
    private CategoryDTO category;
}
