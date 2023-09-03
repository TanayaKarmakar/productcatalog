package com.app.product.productcatalog.models.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product extends BaseModel {
    private String title;
    private String description;
    private BigDecimal price;
    private String image;
    private Category category;
}
