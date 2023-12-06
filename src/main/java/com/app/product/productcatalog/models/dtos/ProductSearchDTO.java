package com.app.product.productcatalog.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchDTO {
    private String query;
    private int pageNumber;
    private int pageSize;
}
