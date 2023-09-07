package com.app.product.productcatalog.models.dtos;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


@Data
@ToString
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private String image;
    private String description;
    private String category;
}
