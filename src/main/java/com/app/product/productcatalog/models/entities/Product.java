package com.app.product.productcatalog.models.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
@Getter
public class Product extends BaseModel {
    private String title;
    private String description;
    private BigDecimal price;
    private String image;
    private Category category;
}
