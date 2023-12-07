package com.app.product.productcatalog.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductSearchDTO {
    private String query;
    private int pageNumber;
    private int pageSize;
    private List<SortParameterDTO> sortBy;
}
